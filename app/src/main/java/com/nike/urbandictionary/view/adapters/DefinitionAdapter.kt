package com.nike.urbandictionary.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.nike.urbandictionary.api.model.Definition
import com.nike.urbandictionary.databinding.DefinitionItemCardvBinding

class DefinitionAdapter :
    ListAdapter<Definition, DefinitionViewHolder>(DefinitionDiffItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefinitionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        val definitionItemCardvBinding =
            DefinitionItemCardvBinding.inflate(layoutInflater, parent, false)

        return DefinitionViewHolder(definitionItemCardvBinding)
    }

    override fun onBindViewHolder(definitionHolder: DefinitionViewHolder, position: Int) {
        definitionHolder.bind((getItem(position)))

    }
}