package ua.turskyi.expandedrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.entity.node.BaseNode
import kotlinx.android.synthetic.main.activity_node_section.*
import ua.turskyi.expandedrecyclerview.decoration.GridSectionAverageGapItemDecoration
import ua.turskyi.expandedrecyclerview.section.ItemNode
import ua.turskyi.expandedrecyclerview.section.NodeSectionAdapter
import ua.turskyi.expandedrecyclerview.section.RootNode
import ua.turskyi.expandedrecyclerview.utils.Tips
import java.util.*

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
open class MainActivity : AppCompatActivity(R.layout.activity_node_section) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.addItemDecoration( GridSectionAverageGapItemDecoration(10, 10, 20, 15))
        val nodeAdapter = NodeSectionAdapter()
        rvList.adapter = nodeAdapter
        nodeAdapter.setList(getEntities())
        rvList.scheduleLayoutAnimation()
        initListeners(nodeAdapter)
    }

    private fun initListeners(nodeSectionAdapter: NodeSectionAdapter) {
        nodeSectionAdapter.onImageClickListener = {
            Tips.show("image")
        }
        nodeSectionAdapter.onTextClickListener = {
            Tips.show("text")
        }

        nodeSectionAdapter.onLongClickListener = {
            Tips.show("long click")
        }
    }

    private fun getEntities(): List<BaseNode> {
        val list: MutableList<BaseNode> = ArrayList()
        for (dummySections in 0..7) {

           /* Item Node*/
            val itemEntity1 = ItemNode("Root $dummySections - SecondNode 0")
            val itemEntity2 = ItemNode("Root $dummySections - SecondNode 1")
            val itemEntity3 = ItemNode("Root $dummySections - SecondNode 2")
            val itemEntity4 = ItemNode("Root $dummySections - SecondNode 3")
            val itemEntity5 = ItemNode("Root $dummySections - SecondNode 4")
            val items: MutableList<BaseNode> = ArrayList()
            items.add(itemEntity1)
            items.add(itemEntity2)
            items.add(itemEntity3)
            items.add(itemEntity4)
            items.add(itemEntity5)

           /* Root Node*/
            val entity = RootNode(R.mipmap.click_head_img_0, items, "Root Node $dummySections")
                entity.isExpanded = false
            list.add(entity)
        }
        return list
    }
}
