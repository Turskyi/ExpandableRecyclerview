package ua.turskyi.expandedrecyclerview

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.entity.node.BaseNode
import ua.turskyi.expandedrecyclerview.section.NodeSectionAdapter
import ua.turskyi.expandedrecyclerview.base.BaseActivity
import ua.turskyi.expandedrecyclerview.decoration.GridSectionAverageGapItemDecoration
import ua.turskyi.expandedrecyclerview.section.ItemNode
import ua.turskyi.expandedrecyclerview.section.RootNode
import kotlinx.android.synthetic.main.activity_node_section.*
import java.util.*

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
open class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_section)
        setBackBtn()
        rvList.layoutManager = GridLayoutManager(this, 3)
        rvList.addItemDecoration( GridSectionAverageGapItemDecoration(10, 10, 20, 15))
        val nodeAdapter = NodeSectionAdapter()

     /*  header*/
        val view: View = layoutInflater.inflate(R.layout.head_view, rvList, false)
        view.findViewById<View>(R.id.iv).visibility = View.GONE
        nodeAdapter.addHeaderView(view)
        rvList.adapter = nodeAdapter
        nodeAdapter.setList(getEntity())
        rvList.scheduleLayoutAnimation()
    }

    private fun getEntity(): List<BaseNode> {
        val list: MutableList<BaseNode> = ArrayList()
        for (dummySections in 0..7) {

           /* Item Node*/
            val itemEntity1 = ItemNode(R.mipmap.click_head_img_0, "Root $dummySections - SecondNode 0")
            val itemEntity2 = ItemNode(R.mipmap.click_head_img_0, "Root $dummySections - SecondNode 1")
            val itemEntity3 = ItemNode(R.mipmap.click_head_img_0, "Root $dummySections - SecondNode 2")
            val itemEntity4 = ItemNode(R.mipmap.click_head_img_0, "Root $dummySections - SecondNode 3")
            val itemEntity5 = ItemNode(R.mipmap.click_head_img_0, "Root $dummySections - SecondNode 4")
            val items: MutableList<BaseNode> = ArrayList()
            items.add(itemEntity1)
            items.add(itemEntity2)
            items.add(itemEntity3)
            items.add(itemEntity4)
            items.add(itemEntity5)

           /* Root Node*/
            val entity = RootNode(items, "Root Node $dummySections")
//            if (dummySections == 1) {
                entity.isExpanded = false
//            }
            list.add(entity)
        }
        return list
    }
}
