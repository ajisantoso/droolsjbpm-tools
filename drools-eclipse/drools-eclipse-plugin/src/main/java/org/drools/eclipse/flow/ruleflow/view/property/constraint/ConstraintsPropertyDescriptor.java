package org.drools.eclipse.flow.ruleflow.view.property.constraint;
/*
 * Copyright 2005 JBoss Inc
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.drools.ruleflow.core.ISplit;
import org.drools.ruleflow.core.IRuleFlowProcess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.PropertyDescriptor;

/**
 * Property descriptor for constraints.
 * 
 * @author <a href="mailto:kris_verlaenen@hotmail.com">Kris Verlaenen</a>
 */
public class ConstraintsPropertyDescriptor extends PropertyDescriptor {
    
    private IRuleFlowProcess process;
    private ISplit split;
    
    public ConstraintsPropertyDescriptor(Object id, String displayName, ISplit split, IRuleFlowProcess process) {
        super(id, displayName);
        this.split = split;
        this.process = process;
    }
    
    public IRuleFlowProcess getProcess() {
        return process;
    }
    
    public CellEditor createPropertyEditor(Composite parent) {
        ConstraintListCellEditor editor = new ConstraintListCellEditor(parent, process, split);
        if (getValidator() != null) {
            editor.setValidator(getValidator());
        }
        return editor;
    }
}