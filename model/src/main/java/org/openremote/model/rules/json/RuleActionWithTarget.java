/*
 * Copyright 2018, OpenRemote Inc.
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
package org.openremote.model.rules.json;

import org.openremote.model.query.AssetQuery;
import org.openremote.model.query.UserQuery;

/**
 * Indicates that the action should be scoped to the specified {@link Target}.
 */
public abstract class RuleActionWithTarget implements RuleAction {

    /**
     * Only one of the options should be set the precedence is:
     * <ol>
     * <li>{@link #useAssetsFromWhen}</li>
     * <li>{@link #assets}</li>
     * <li>{@link #users}</li>
     * </ol>
     */
    public static class Target {
        public boolean useAssetsFromWhen;
        public AssetQuery assets;
        public UserQuery users;
    }

    public Target target;
}
