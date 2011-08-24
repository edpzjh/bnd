/*******************************************************************************
* Copyright (c) 2010 Neil Bartlett.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Neil Bartlett - initial API and implementation
******************************************************************************/
package aQute.junit.runtime;

public abstract class VoidOperation<S> implements Operation<S, Object> {
public final Object perform(S param) {
doPerform(param);
return null;
}
protected abstract void doPerform(S param);
}