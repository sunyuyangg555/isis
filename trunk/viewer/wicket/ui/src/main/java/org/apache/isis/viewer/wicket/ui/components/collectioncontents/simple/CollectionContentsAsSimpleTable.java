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

package org.apache.isis.viewer.wicket.ui.components.collectioncontents.simple;

import java.util.List;

import org.apache.isis.core.metamodel.adapter.ObjectAdapter;
import org.apache.isis.core.metamodel.spec.ObjectSpecification;
import org.apache.isis.core.metamodel.spec.feature.ObjectAssociation;
import org.apache.isis.core.metamodel.spec.feature.ObjectAssociationFilters;
import org.apache.isis.viewer.wicket.model.models.EntityCollectionModel;
import org.apache.isis.viewer.wicket.model.models.EntityModel;
import org.apache.isis.viewer.wicket.ui.panels.PanelAbstract;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * {@link PanelAbstract Panel} that represents a {@link EntityCollectionModel collection of entity}s rendered using a
 * simple HTML table.
 */
public class CollectionContentsAsSimpleTable extends PanelAbstract<EntityCollectionModel> {

    private static final long serialVersionUID = 1L;

    public CollectionContentsAsSimpleTable(final String id, final EntityCollectionModel model) {
        super(id, model);

        buildGui();
    }

    private void buildGui() {
        addTableHeader();
        addTableRows();
    }

    private void addTableHeader() {
        final EntityCollectionModel model = getModel();
        final ObjectSpecification typeOfSpec = model.getTypeOfSpecification();
        final RepeatingView propertyNames = new RepeatingView("propertyName");
        add(propertyNames);

        final List<? extends ObjectAssociation> propertyList =
            typeOfSpec.getAssociations(ObjectAssociationFilters.PROPERTIES);
        for (final ObjectAssociation property : propertyList) {
            propertyNames.add(new Label(property.getId(), property.getName()));
        }
    }

    private void addTableRows() {
        final EntityCollectionModel model = getModel();
        final List<ObjectAdapter> adapterList = model.getObject();
        final RepeatingView entityInstances = new RepeatingView("entityInstance");
        add(entityInstances);
        for (final ObjectAdapter adapter : adapterList) {
            final String childId = entityInstances.newChildId();
            entityInstances.add(new CollectionContentsInstanceAsTableRow(childId, new EntityModel(adapter)));
        }
    }
}
