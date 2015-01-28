/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/

/**
 * Created by Evgen on 1/21/15.
 */
package org.wso2.developerstudio.codenvy.ext.esb.client.messages;

import com.google.gwt.webworker.client.messages.MessageImpl;

/**
 * @author Evgen Vidolob
 */
public class SaveContentMessage extends MessageImpl {
    protected SaveContentMessage() {
    }

    public static native SaveContentMessage make() /*-{
        return {
            _type : 3
        }
    }-*/;

    public final native String getContent() /*-{
        return this["content"];
    }-*/;

    public final native String getFilePath() /*-{
        return this["filePath"];
    }-*/;
}
