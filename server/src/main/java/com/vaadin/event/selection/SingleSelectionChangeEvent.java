/*
 * Copyright 2000-2016 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.event.selection;

import java.util.Optional;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.ui.AbstractListing;
import com.vaadin.ui.AbstractSingleSelect;

/**
 * Fired when the selection changes in a listing component.
 * 
 * @author Vaadin Ltd.
 *
 * @param <T>
 *            the type of the selected item
 * @since 8.0
 */
public class SingleSelectionChangeEvent<T> extends ValueChangeEvent<T>
        implements SelectionEvent<T> {

    /**
     * Creates a new selection change event.
     * 
     * @param source
     *            the listing that fired the event
     * @param userOriginated
     *            {@code true} if this event originates from the client,
     *            {@code false} otherwise.
     */
    public SingleSelectionChangeEvent(AbstractSingleSelect<T> source,
            boolean userOriginated) {
        super(source, userOriginated);
    }

    /**
     * Returns an optional of the item that was selected, or an empty optional
     * if a previously selected item was deselected.
     * <p>
     * The result is the current selection of the source
     * {@link AbstractSingleSelect} object. So it's always exactly the same as
     * optional describing {@link AbstractSingleSelect#getValue()}.
     * 
     * @see #getValue()
     * 
     * @return the selected item or an empty optional if deselected
     *
     * @see SelectionModel.Single#getSelectedItem()
     */
    public Optional<T> getSelectedItem() {
        return Optional.ofNullable(getValue());
    }

    @Override
    @SuppressWarnings("unchecked")
    public AbstractListing<T, ?> getComponent() {
        return (AbstractListing<T, ?>) super.getComponent();
    }

    @Override
    public Optional<T> getFirstSelected() {
        return getSelectedItem();
    }
}
