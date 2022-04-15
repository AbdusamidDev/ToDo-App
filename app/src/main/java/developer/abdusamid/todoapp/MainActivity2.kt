package developer.abdusamid.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdusamid.todoapp.Adapter.ExpandableAdapter
import developer.abdusamid.todoapp.MyShare.MyShare
import developer.abdusamid.todoapp.Object.Object
import developer.abdusamid.todoapp.Object.Object.todoListName
import developer.abdusamid.todoapp.UserData.ForUserData
import developer.abdusamid.todoapp.UserData.UserData
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var expandableAdapter: ExpandableAdapter
    lateinit var titleList: ArrayList<String>
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var arrayListData: ArrayList<ForUserData>
    lateinit var dataList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        expandablelistview_TodoList.setOnGroupClickListener { parent, v, groupPosition, id ->
            Object.todoListName = titleList[groupPosition]
            false
        }
        expandablelistview_TodoList.setOnGroupExpandListener {
            for (w in 0 until titleList.size) {
                if (w != it) {
                    expandablelistview_TodoList.collapseGroup(w)
                }
            }
        }
    }

    private fun MyWork() {
        dataList = ArrayList()
        titleList = ArrayList()
        map = HashMap()
        arrayListData = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        titleList = dataList[0].titleList
        map = dataList[0].map
        arrayListData = dataList[0].arrayListData
        for (k in titleList) {
            val arrayList = ArrayList<String>()
            for (i in 0 until arrayListData.size) {
                if (arrayListData[i].todoListName == k) {
                    arrayList.add(arrayListData[i].todoName)
                }
            }
            map[k] = arrayList
        }
    }

    override fun onResume() {
        MyShare.init(this)
        MyWork()
        if (expandablelistview_TodoList.adapter != null) {
            for (i in 0 until titleList.size) {
                expandablelistview_TodoList.collapseGroup(i)
            }
        }
        expandableAdapter = ExpandableAdapter(titleList, map, this)
        expandablelistview_TodoList.setAdapter(expandableAdapter)
        super.onResume()
    }
}