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
package org.wso2.developerstudio.codenvy.ext.esb.client.editor.multipage;

import com.codenvy.ide.api.editor.EditorPartPresenter;
import com.codenvy.ide.api.editor.EditorProvider;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import javax.annotation.Nonnull;

/**
 * @author Evgen Vidolob
 */
@Singleton
public class ESBMultiPageEditorProvider implements EditorProvider {

    private final Provider<ESBMultiPageEditor> provider;

    @Inject
    public ESBMultiPageEditorProvider(Provider<ESBMultiPageEditor> provider) {
        this.provider = provider;
    }

    @Override
    public String getId() {
        return "DBSMultiPageEditor";
    }

    @Override
    public String getDescription() {
        return "Description...";
    }

    @Nonnull
    @Override
    public EditorPartPresenter getEditor() {
        return provider.get();
    }
}
