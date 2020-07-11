package com.nike.urbandictionary.view.adapters

import androidx.recyclerview.widget.RecyclerView
import com.nike.urbandictionary.R
import com.nike.urbandictionary.api.model.Definition
import com.nike.urbandictionary.databinding.DefinitionItemCardvBinding
import com.nike.urbandictionary.utilities.DateFormat

class DefinitionViewHolder(private val definitionItemCardvBinding: DefinitionItemCardvBinding) :
    RecyclerView.ViewHolder(definitionItemCardvBinding.root) {

    fun bind(definition: Definition) {
        definitionItemCardvBinding.definitionCardvBinding = definition
        val dateFormat = DateFormat()
        val dateString = definition.date.let { dateFormat.getDate(it) }
        var author = definition.author
        if (author.length > 12) {
            author = author.substring(0, 12)
        }

        /*definitionItemCardvBinding.tvAuthor.text =
            definitionItemCardvBinding.root.context.getString(R.string.tvAuthor).plus(author)
                .plus(" - ").plus(dateString)*/

        definitionItemCardvBinding.tvAuthor.text = definitionItemCardvBinding.root.context.getString(R.string.tvAuthor, author, dateString)
        definitionItemCardvBinding.executePendingBindings()
    }

}