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
package org.test.ext.dialog.client;

import com.codenvy.ide.api.action.ActionManager;
import com.codenvy.ide.api.action.DefaultActionGroup;
import com.codenvy.ide.api.action.IdeActions;
import com.codenvy.ide.api.extension.Extension;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Created by susinda on 1/26/15.
 */

@Singleton
@Extension(title = "Dialog Extension", description = "Test Dialog Extension", version = "1.0.0")
public class TestDialogExtension {

    @Inject
    public TestDialogExtension(ActionManager actionManager, TestDialogAction testDialogAction) {

        actionManager.registerAction("Test Dialog", testDialogAction);
        DefaultActionGroup fileMenuGroup = (DefaultActionGroup)actionManager.getAction(IdeActions.GROUP_FILE);
        fileMenuGroup.add(testDialogAction);
    }
}

