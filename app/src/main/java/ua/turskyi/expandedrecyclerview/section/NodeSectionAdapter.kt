package ua.turskyi.expandedrecyclerview.section

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode
import ua.turskyi.expandedrecyclerview.section.providers.RootNodeProvider
import ua.turskyi.expandedrecyclerview.section.providers.SecondNodeProvider

class NodeSectionAdapter : BaseNodeAdapter() {

    private var provider = RootNodeProvider()

    init {
        addFullSpanNodeProvider(provider)
        addNodeProvider(SecondNodeProvider())
    }

    var onImageClickListener: ((data: RootNode?) -> Unit)? = null
        set(value) {
            provider.onImageClickListener = value
            field = value
        }

    var onTextClickListener: ((data: RootNode?) -> Unit)? = null
        set(value) {
            provider.onTextClickListener = value
            field = value
        }

    var onLongClickListener: ((data: RootNode?) -> Unit)? = null
        set(value) {
            provider.onLongLickListener = value
            field = value
        }

    override fun getItemType(
        data: List<BaseNode>,
        position: Int
    ): Int {
        return when (data[position]) {
            is RootNode -> 0
            is ItemNode -> 1
            else -> -1
        }
    }
}