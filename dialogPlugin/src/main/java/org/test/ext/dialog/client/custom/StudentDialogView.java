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
package org.test.ext.dialog.client.custom;

import com.google.inject.ImplementedBy;

/**
 * Created by susinda on 1/26/15.
 */

@ImplementedBy(StudentDialogViewImpl.class)
public interface StudentDialogView {

    /** Sets the action delegate. */
    void setDelegate(ActionDelegate delegate);

    /** Displays the dialog window. */
    void showDialog();

    /** Closes the dialog window. */
    void closeDialog();

    /** Sets the Name of student */
    void setName(String value);

    /** Gets the Name of student */
    String getName();

    /** Sets the Age of student */
    void setAge(String title);

    /** Gets the Age of student */
    String getAge();

    /** Sets the isGraduate value of student */
    void setIsGraduate(String graduate);

    /** Gets the Age of student */
    String isGraduate();


    /**
     * Show the validation error message.
     * @param message
     */
    void showErrorHint(String message);

    /** Hide the validation error message. */
    void hideErrorHint();



    /** The interface for the action delegate. */
    public interface ActionDelegate {

        /** Defines what's done when the user clicks cancel. */
        void cancelled();

        /** Defines what's done when the user clicks OK. */
        void accepted();
    }
}