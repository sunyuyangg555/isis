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
package org.apache.isis.objectstore.jdo.metamodel.facets.prop.column;

import java.math.BigDecimal;

import javax.jdo.annotations.Column;

import org.apache.isis.applib.annotation.MemberOrder;


public class SimpleObjectWithBigDecimalColumnAnnotations {

    private BigDecimal bigDecimalPropertyWithColumnAnnotation;

    @Column(length=12,scale=3)
    public BigDecimal getBigDecimalPropertyWithColumnAnnotation() {
        return bigDecimalPropertyWithColumnAnnotation;
    }

    public void setBigDecimalPropertyWithColumnAnnotation(final BigDecimal val) {
        this.bigDecimalPropertyWithColumnAnnotation = val;
    }

    // //////////////////////////////////////

    private BigDecimal bigDecimalPropertyWithColumnAnnotationMissingLength;

    @Column(scale=3)
    public BigDecimal getBigDecimalPropertyWithColumnAnnotationMissingLength() {
        return bigDecimalPropertyWithColumnAnnotationMissingLength;
    }

    public void setBigDecimalPropertyWithColumnAnnotationMissingLength(final BigDecimal val) {
        this.bigDecimalPropertyWithColumnAnnotationMissingLength = val;
    }

    // //////////////////////////////////////

    private BigDecimal bigDecimalPropertyWithColumnAnnotationMissingScale;

    @Column(length=12)
    public BigDecimal getBigDecimalPropertyWithColumnAnnotationMissingScale() {
        return bigDecimalPropertyWithColumnAnnotationMissingScale;
    }

    public void setBigDecimalPropertyWithColumnAnnotationMissingScale(final BigDecimal val) {
        this.bigDecimalPropertyWithColumnAnnotationMissingScale = val;
    }

    // //////////////////////////////////////

    private String stringPropertyWithColumnAnnotation;

    @Column(length=12, scale=3)
    public String getStringPropertyWithColumnAnnotation() {
        return stringPropertyWithColumnAnnotation;
    }

    public void setStringPropertyWithColumnAnnotation(final String stringPropertyWithColumnAnnotation) {
        this.stringPropertyWithColumnAnnotation = stringPropertyWithColumnAnnotation;
    }

    // //////////////////////////////////////

    private BigDecimal bigDecimalPropertyWithoutColumnAnnotation;

    public BigDecimal getBigDecimalPropertyWithoutColumnAnnotation() {
        return bigDecimalPropertyWithoutColumnAnnotation;
    }

    public void setBigDecimalPropertyWithoutColumnAnnotation(final BigDecimal bigDecimalPropertyWithoutColumnAnnotation) {
        this.bigDecimalPropertyWithoutColumnAnnotation = bigDecimalPropertyWithoutColumnAnnotation;
    }


}