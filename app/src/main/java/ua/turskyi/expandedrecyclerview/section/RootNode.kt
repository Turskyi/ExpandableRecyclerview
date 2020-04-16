package ua.turskyi.expandedrecyclerview.section

import androidx.annotation.DrawableRes
import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode

class RootNode(
    @get:DrawableRes
    @param:DrawableRes var img: Int,
    override val childNode: MutableList<BaseNode>, val title: String) : BaseExpandNode()
