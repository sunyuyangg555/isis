/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.apache.isis.runtimes.dflt.remoting.transport;

import org.apache.isis.core.commons.exceptions.IsisException;

/**
 * Indicates that a connection could not be established between the client and the server.
 */
public class ConnectionException extends IsisException {
    private static final long serialVersionUID = 1L;

    public ConnectionException() {
        super();
    }

    public ConnectionException(final String msg) {
        super(msg);
    }

    public ConnectionException(final Throwable cause) {
        super(cause);
    }

    public ConnectionException(final String msg, final Throwable cause) {
        super(msg, cause);
    }

}
