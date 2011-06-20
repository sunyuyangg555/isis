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
package org.apache.isis.viewer.restful.applib;

import static org.apache.isis.viewer.restful.applib.StringUtils.asString;
import static org.apache.isis.viewer.restful.applib.UrlConnectionUtils.createGetConnection;
import static org.apache.isis.viewer.restful.applib.UrlConnectionUtils.createPostConnection;
import static org.apache.isis.viewer.restful.applib.UrlConnectionUtils.readDocFromConnectionInputStream;
import static org.apache.isis.viewer.restful.applib.UrlConnectionUtils.writeMapToConnectionOutputStream;
import static org.apache.isis.viewer.restful.applib.UrlEncodeUtils.urlEncode;

import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.output.XMLOutputter;

public abstract class AbstractRestfulClient {

    private static Logger LOG = Logger.getLogger(AbstractRestfulClient.class);

    private final String hostUri;

    public String getHostUri() {
        return hostUri;
    }

    public AbstractRestfulClient(final String hostUri) {
        this.hostUri = hostUri;
    }

    public Document get(final String uri) throws RestfulClientException {
        if (LOG.isInfoEnabled()) {
            LOG.info("getting from '" + uri + "'");
        }
        try {
            final HttpURLConnection connection = createGetConnection(uri);
            final Document document = readDocFromConnectionInputStream(connection);
            if (LOG.isTraceEnabled()) {
                StringWriter sw = new StringWriter();
                new XMLOutputter().output(document, sw);
                LOG.trace(sw.toString());
            }
            return document;
        } catch (final ProtocolException e) {
            throw new RestfulClientException(e);
        } catch (final IOException e) {
            throw new RestfulClientException(e);
        } catch (JDOMException e) {
            throw new RestfulClientException(e);
        }
    }

    public org.jdom.Document post(final String uri, final String... paramArgs) {
        return post(uri, StringUtils.asMap(paramArgs));
    }

    private org.jdom.Document post(final String uri, final Map<String, String> formArgumentsByParameter) {
        if (LOG.isInfoEnabled()) {
            LOG.info("posting form arguments to '" + uri + "'");
            LOG.info(asString(formArgumentsByParameter));
        }
        try {
            final Map<String, String> encodedMap = urlEncode(formArgumentsByParameter);
            if (LOG.isTraceEnabled()) {
                LOG.trace(asString(encodedMap));
            }
            final HttpURLConnection connection = createPostConnection(uri);
            writeMapToConnectionOutputStream(encodedMap, connection);
            return readDocFromConnectionInputStream(connection);
        } catch (final IOException e) {
            throw new RestfulClientException(e);
        } catch (JDOMException e) {
            throw new RestfulClientException(e);        }
    }

    // //////////////////////////////////////////////////////////////////////
    // Helpers: string
    // //////////////////////////////////////////////////////////////////////

    protected static String combine(final String... pathParts) {
        final StringBuilder buf = new StringBuilder();
        for (final String part : pathParts) {
            buf.append(part);
        }
        return buf.toString();
    }

}
