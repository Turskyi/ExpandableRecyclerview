package ua.turskyi.expandedrecyclerview.section

import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode
import ua.turskyi.expandedrecyclerview.section.provider.RootNodeProvider
import ua.turskyi.expandedrecyclerview.section.provider.SecondNodeProvider

class NodeSectionAdapter : BaseNodeAdapter() {
    init {
        addFullSpanNodeProvider(RootNodeProvider())
        addNodeProvider(SecondNodeProvider())
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