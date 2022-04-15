package developer.abdusamid.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import developer.abdusamid.todoapp.Adapter.ExpandableAdapter
import developer.abdusamid.todoapp.MyShare.MyShare
import developer.abdusamid.todoapp.MyShare.MyShare.dataList
import developer.abdusamid.todoapp.UserData.ForUserData
import developer.abdusamid.todoapp.UserData.UserData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var expandableAdapter: ExpandableAdapter
    lateinit var titleList: ArrayList<String>
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var arrayListData: ArrayList<ForUserData>
    lateinit var dataList: ArrayList<UserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyShare.init(this)
        dataList = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        if (dataList.isEmpty()) {
            BirinchiMartaIshgaTushganda()
        }
        btn_TodoList.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        btn_addTodo.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)

        }
    }

    private fun BirinchiMartaIshgaTushganda() {
        val arrayList = ArrayList<String>()
        arrayList.add("To do 1")
        titleList = ArrayList()
        map = HashMap()
        arrayListData = ArrayList()
        titleList.add("Open")
        titleList.add("Development")
        titleList.add("Uploading")
        titleList.add("Reject")
        titleList.add("Closed")
        arrayListData.add(
            ForUserData(
                "Open",
                "To do 1",
                "Finish homework",
                "Urgent",
                "Programming",
                "17.01.2021"
            )
        )
        map[titleList[0]] = arrayList
        dataList.add(UserData(titleList, map, arrayListData))
        MyShare.dataList = dataList
    }
}