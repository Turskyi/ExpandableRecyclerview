package ua.turskyi.expandedrecyclerview.section.provider

import android.view.View
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import ua.turskyi.expandedrecyclerview.section.RootFooterNode
import ua.turskyi.expandedrecyclerview.utils.Tips
import ua.turskyi.expandedrecyclerview.R

class RootFooterNodeProvider : BaseNodeProvider() {
    init {
        addChildClickViewIds(R.id.footerTv)
    }
    override val itemViewType: Int
        get() = 2

    override val layoutId: Int
        get() = R.layout.node_footer

    override fun convert(
        helper: BaseViewHolder,
        item: BaseNode
    ) {
        val entity: RootFooterNode? = item as RootFooterNode?
        helper.setText(R.id.footerTv, entity?.title)
    }

    override fun onChildClick(
        helper: BaseViewHolder,
        view: View,
        data: BaseNode,
        position: Int
    ) {
        if (view.id == R.id.footerTv) {
            Tips.show("Footer Node Click : $position")
        }
    }
}