package com.nike.urbandictionary.view.adapters

import androidx.recyclerview.widget.DiffUtil
import com.nike.urbandictionary.api.model.Definition

class DefinitionDiffItemCallback : DiffUtil.ItemCallback<Definition>() {
    override fun areItemsTheSame(oldItem: Definition, newItem: Definition) =
        oldItem.definition == newItem.definition

    override fun areContentsTheSame(oldItem: Definition, newItem: Definition) = oldItem == newItem
}