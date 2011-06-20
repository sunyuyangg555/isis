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

package org.apache.isis.viewer.wicket.viewer.integration.nof;

import org.apache.isis.runtimes.dflt.runtime.system.DeploymentCategory;
import org.apache.isis.runtimes.dflt.runtime.system.DeploymentType;

/**
 * {@link DeploymentType} for exploration usage.
 * 
 * <p>
 * TODO: this is currently only partly honoured; exploration actions are shown and the correct object store is defaulted
 * (ie in-memory); however Wicket Objects will always pop up a login dialog.
 */
public class WicketServerExploration extends DeploymentTypeAbstract {

    public WicketServerExploration() {
        super("WICKET_SERVER_EXPLORATION", DeploymentCategory.EXPLORING);
    }

}
