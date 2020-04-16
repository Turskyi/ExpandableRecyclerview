package ua.turskyi.expandedrecyclerview.section

import androidx.annotation.DrawableRes
import com.chad.library.adapter.base.entity.node.BaseNode

class ItemNode(
    @get:DrawableRes
    @param:DrawableRes var img: Int, var name: String
) :
    BaseNode() {

    override val childNode: MutableList<BaseNode>?
        get() = null

}