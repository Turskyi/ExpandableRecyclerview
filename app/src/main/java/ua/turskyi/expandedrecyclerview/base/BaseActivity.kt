package ua.turskyi.expandedrecyclerview.base

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ua.turskyi.expandedrecyclerview.R

abstract class BaseActivity : AppCompatActivity() {

    companion object{
        protected const val TAG = "Base"
    }
    private var back: ImageView? = null

    private var rootLayout: LinearLayout? = null

    /**
     * sometime you want to define back event
     */
    protected fun setBackBtn() {
        if (back != null) {
            back?.visibility = View.VISIBLE
            back?.setOnClickListener { finish() }
        } else {
            Log.d(TAG,"back is null ,please check out")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
            WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
        )
        super.setContentView(R.layout.activity_base)
    }

    override fun setContentView(layoutId: Int) {
        setContentView(View.inflate(this, layoutId, null))
    }

    override fun setContentView(view: View) {
        rootLayout = findViewById(R.id.root_layout)
        if (rootLayout == null) {
            return
        }
        rootLayout?.addView(
            view,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }
}