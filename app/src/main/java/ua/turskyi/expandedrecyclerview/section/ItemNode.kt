package ua.turskyi.expandedrecyclerview.section

import com.chad.library.adapter.base.entity.node.BaseNode

class ItemNode(var name: String) : BaseNode() {
    override val childNode: MutableList<BaseNode>?
        get() = null
}