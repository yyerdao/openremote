/*
 * Copyright 2017, OpenRemote Inc.
 *
 * See the CONTRIBUTORS.txt file in the distribution for a
 * full listing of individual contributors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.openremote.manager.server.security;

import org.openremote.container.security.AuthContext;
import org.openremote.container.security.IdentityProvider;
import org.openremote.container.web.ClientRequestInfo;
import org.openremote.manager.shared.security.*;
import org.openremote.model.asset.Asset;

/**
 * SPI for implementations used by {@link ManagerIdentityService}, provides CRUD of
 * {@link User} and {@link Tenant}.
 */
public interface ManagerIdentityProvider extends IdentityProvider {

    User[] getUsers(ClientRequestInfo clientRequestInfo, String realm);

    User getUser(ClientRequestInfo clientRequestInfo, String realm, String userId);

    void updateUser(ClientRequestInfo clientRequestInfo, String realm, String userId, User user);

    void createUser(ClientRequestInfo clientRequestInfo, String realm, User user);

    void deleteUser(ClientRequestInfo clientRequestInfo, String realm, String userId);

    void resetPassword(ClientRequestInfo clientRequestInfo, String realm, String userId, Credential credential);

    Role[] getRoles(ClientRequestInfo clientRequestInfo, String realm, String userId);

    void updateRoles(ClientRequestInfo clientRequestInfo, String realm, String userId, Role[] roles);

    boolean isMasterRealmAdmin(ClientRequestInfo clientRequestInfo, String userId);

    Tenant[] getTenants(ClientRequestInfo clientRequestInfo);

    Tenant getTenantForRealm(String realm);

    Tenant getTenantForRealmId(String realmId);

    void updateTenant(ClientRequestInfo clientRequestInfo, String realm, Tenant tenant);

    void createTenant(ClientRequestInfo clientRequestInfo, Tenant tenant);

    void createTenant(ClientRequestInfo clientRequestInfo, Tenant tenant, TenantEmailConfig emailConfig);

    void deleteTenant(ClientRequestInfo clientRequestInfo, String realm);

    boolean isTenantActiveAndAccessible(AuthContext authContext, Tenant tenant);

    boolean isTenantActiveAndAccessible(AuthContext authContext, Asset asset);

    String[] getActiveTenantIds();

    boolean isActiveTenant(String realmId);
}