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
 * Created by Evgen on 1/22/15.
 */
package org.wso2.developerstudio.codenvy.ext.esb.client.editor;

/**
 * @author Evgen Vidolob
 */
public interface WSO2IFrameEditor {

    void saveContent(String content);

    void setDirtyState(boolean dirty);
}
