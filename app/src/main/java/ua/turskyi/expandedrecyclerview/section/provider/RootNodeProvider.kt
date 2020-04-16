package ua.turskyi.expandedrecyclerview.section.provider

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import ua.turskyi.expandedrecyclerview.R
import ua.turskyi.expandedrecyclerview.section.RootNode

class RootNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 0

    override val layoutId: Int
        get() = R.layout.def_section_head

    var onImageClickListener: ((data: RootNode?) -> Unit)? = null
    var onTextClickListener: ((data: RootNode?) -> Unit)? = null
    var onLongLickListener: ((data: RootNode?) -> Unit)? = null

    override fun convert(
        helper: BaseViewHolder,
        item: BaseNode
    ) {
        val entity: RootNode? = item as RootNode?
        helper.getView<TextView>(R.id.header).setOnLongClickListener{
            onLongLickListener?.invoke(entity)!!
            true
        }
        entity?.img?.let { helper.setImageResource(R.id.iv, it) }
        helper.setText(R.id.header, entity?.title)
        helper.getView<ImageView>(R.id.iv).setOnClickListener {
            onImageClickListener?.invoke(entity)
        }
        helper.getView<TextView>(R.id.header).setOnClickListener {
            onTextClickListener?.invoke(entity)
        }
        if (!item.childNode.isNullOrEmpty()) {
            entity?.let {
                if (entity.isExpanded) {
                    helper.setImageResource(
                        R.id.more,
                        R.drawable.ic_arrow_expandable_up
                    )
                } else {
                    helper.setImageResource(
                        R.id.more,
                        R.drawable.ic_arrow_expandable_down
                    )
                }
            }
            helper.setVisible(R.id.more, true)
        } else {
            helper.setVisible(R.id.more, false)
        }
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