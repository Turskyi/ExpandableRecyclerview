package ua.turskyi.expandedrecyclerview.section.provider

import android.view.View
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import ua.turskyi.expandedrecyclerview.section.RootNode
import ua.turskyi.expandedrecyclerview.R

class RootNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 0

    override val layoutId: Int
        get() = R.layout.def_section_head

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity: RootNode? = item as RootNode?
        helper.setText(R.id.header, entity?.title)
    }

    override fun onClick(
        helper: BaseViewHolder,
        view: View,
        data: BaseNode,
        position: Int
    ) {
        getAdapter()?.expandOrCollapse(position)
    }
}