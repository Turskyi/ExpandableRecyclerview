package ua.turskyi.expandedrecyclerview.section.provider

import android.view.View
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import ua.turskyi.expandedrecyclerview.section.ItemNode
import ua.turskyi.expandedrecyclerview.R

class SecondNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 1

    override val layoutId: Int
        get() = R.layout.item_section_content

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity: ItemNode = item as ItemNode
        helper.setImageResource(R.id.iv, entity.img)
        helper.setText(R.id.tv, entity.name)
    }

    override fun onClick(
        helper: BaseViewHolder,
        view: View,
        data: BaseNode,
        position: Int
    ) {
    }
}