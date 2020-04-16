package ua.turskyi.expandedrecyclerview.section

import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode

class RootNode(override val childNode: MutableList<BaseNode>, val title: String) : BaseExpandNode()
