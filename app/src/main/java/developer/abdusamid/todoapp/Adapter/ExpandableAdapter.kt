package developer.abdusamid.todoapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import developer.abdusamid.todoapp.MainActivity
import developer.abdusamid.todoapp.MainActivity3
import developer.abdusamid.todoapp.Object.Object
import developer.abdusamid.todoapp.R
import kotlinx.android.synthetic.main.dinamikview_chiled.view.*
import kotlinx.android.synthetic.main.dinamikview_todolist.view.*

class ExpandableAdapter(
    private var titleList: ArrayList<String>,
    var map: HashMap<String, ArrayList<String>>, var context: Context
) : BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleList.size

    override fun getChildrenCount(groupPosition: Int): Int = map[titleList[groupPosition]]!!.size

    override fun getGroup(groupPosition: Int): Any = titleList[groupCount]

    override fun getChild(groupPosition: Int, childPosition: Int): Any =
        map[titleList[groupPosition]]!![childPosition]

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = false

    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        converView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View = converView
            ?: LayoutInflater.from(parent?.context)
                .inflate(R.layout.dinamikview_todolist, parent, false)
        itemView.tv_todolistName.text = titleList[groupPosition]
        return itemView
    }

    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        val itemView: View
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.dinamikview_chiled, parent, false)
        } else {
            itemView = convertView
        }
        itemView.tv_todolist_childName.text = map[titleList[groupPosition]]!![childPosition]
        itemView.setOnClickListener {
            Object.todoName = map[titleList[groupPosition]]!![childPosition]
            val intent = Intent(context, MainActivity3::class.java)
            context.startActivity(intent)
        }
        return itemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = false
}