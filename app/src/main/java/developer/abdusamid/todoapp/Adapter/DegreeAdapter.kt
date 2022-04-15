package developer.abdusamid.todoapp.Adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import developer.abdusamid.todoapp.DegreeClass
import developer.abdusamid.todoapp.R
import kotlinx.android.synthetic.main.dinamikview_degree.view.*

class DegreeAdapter(var context: Context, private val degreeList: ArrayList<DegreeClass>) :
    BaseAdapter() {
    override fun getCount(): Int = degreeList.size

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView
            ?: LayoutInflater.from(parent?.context)
                .inflate(R.layout.dinamikview_degree, parent, false)
        view.tv_degree.text = degreeList[position].string
        view.image_degree.setImageResource(degreeList[position].int!!)
        return view
    }
}