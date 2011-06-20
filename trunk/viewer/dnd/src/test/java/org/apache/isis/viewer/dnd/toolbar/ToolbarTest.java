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

package org.apache.isis.viewer.dnd.toolbar;

import static org.junit.Assert.assertEquals;

import org.apache.isis.runtimes.dflt.objectstores.dflt.testsystem.TestProxySystemII;
import org.apache.isis.viewer.dnd.DummyView;
import org.apache.isis.viewer.dnd.TestToolkit;
import org.apache.isis.viewer.dnd.drawing.Location;
import org.apache.isis.viewer.dnd.drawing.Size;
import org.apache.isis.viewer.dnd.view.View;
import org.apache.isis.viewer.dnd.view.content.NullContent;
import org.apache.isis.viewer.dnd.view.look.LookFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class ToolbarTest {

    private ToolbarView toolbar;
    private DummyView button1;
    private DummyView button2;
    private DummyView button3;

    @Before
    public void setup() {
        Logger.getRootLogger().setLevel(Level.OFF);
        new TestProxySystemII().init();
        TestToolkit.createInstance();
        LookFactory.init();

        toolbar = new ToolbarView(new NullContent(), null);

        button1 = new DummyView();
        button1.setupRequiredSize(new Size(120, 10));
        toolbar.addView(button1);

        button2 = new DummyView();
        button2.setupRequiredSize(new Size(100, 10));
        toolbar.addView(button2);

        button3 = new DummyView();
        button3.setupRequiredSize(new Size(80, 10));
        toolbar.addView(button3);
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void requiredSizeForButtonsLessThanMaximumWidth() throws Exception {
        final Size size = toolbar.getRequiredSize(Size.createMax());
        assertEquals(new Size(View.HPADDING + (100 + View.HPADDING) * 3, 10 + View.VPADDING), size);
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void requiredSizeForButtonsGreaterThanMaximumWidth() throws Exception {
        final Size size = toolbar.getRequiredSize(new Size(250, 100));
        assertEquals(new Size(View.HPADDING * 3 + 220, (10 + View.VPADDING) * 2), size);
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void requiredSizeForButtonsJustGreaterThanMaximumWidth() throws Exception {
        final int width = View.HPADDING + (100 + View.HPADDING) * 3;
        final Size size = toolbar.getRequiredSize(new Size(width + 1, 100));
        assertEquals(new Size(width, 10 + View.VPADDING), size);
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void requiredSizeForButtonsSameAsMaximumWidth() throws Exception {
        final Size size = toolbar.getRequiredSize(new Size(View.HPADDING + (100 + View.HPADDING) * 3, 100));
        assertEquals(new Size(View.HPADDING * 3 + 220, (10 + View.VPADDING) * 2), size);
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void layoutSizeForButtonsAsRequired() throws Exception {
        toolbar.doLayout(Size.createMax());
        assertEquals(new Size(120, 10), button1.getSize());
        assertEquals(new Size(100, 10), button2.getSize());
        assertEquals(new Size(80, 10), button3.getSize());
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void layoutLocationForButtonsLessThanMaximumWidth() throws Exception {
        toolbar.doLayout(Size.createMax());
        assertEquals(new Location(View.HPADDING, 0), button1.getLocation());
        assertEquals(new Location(View.HPADDING * 2 + 120, 0), button2.getLocation());
        assertEquals(new Location(View.HPADDING * 3 + 220, 0), button3.getLocation());
    }

    @Ignore("having problems with test classpath - TestProxySystemII can't find JavaReflectorInstaller, for some reason")
    @Test
    public void layoutLocationForButtonsGreaterThanMaximumWidth() throws Exception {
        toolbar.doLayout(new Size(250, 100));
        assertEquals(new Location(View.HPADDING, 0), button1.getLocation());
        assertEquals(new Location(View.HPADDING * 2 + 120, 0), button2.getLocation());
        assertEquals(new Location(View.HPADDING, 13), button3.getLocation());
    }
}
