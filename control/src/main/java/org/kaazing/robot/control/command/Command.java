/*
 * Copyright (c) 2014 "Kaazing Corporation," (www.kaazing.com)
 *
 * This file is part of Robot.
 *
 * Robot is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.kaazing.robot.control.command;

import java.util.Objects;

public abstract class Command {

    public static enum Kind {
        PREPARE, START, ABORT
    }

    public abstract Kind getKind();

    @Override
    public abstract int hashCode();

    @Override
    public boolean equals(Object o) {
        return o == this || o instanceof Command && equalTo((Command) o);
    }

    protected final boolean equalTo(Command that) {
        return Objects.equals(this.getKind(), that.getKind());
    }

}
