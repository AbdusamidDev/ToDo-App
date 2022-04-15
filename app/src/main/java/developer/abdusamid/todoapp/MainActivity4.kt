package developer.abdusamid.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import developer.abdusamid.todoapp.Adapter.DegreeAdapter
import developer.abdusamid.todoapp.MyShare.MyShare
import developer.abdusamid.todoapp.Object.Object
import developer.abdusamid.todoapp.Object.Object.forDegree
import developer.abdusamid.todoapp.UserData.ForUserData
import developer.abdusamid.todoapp.UserData.UserData
import kotlinx.android.synthetic.main.activity_main4.*

class MainActivity4 : AppCompatActivity() {
    lateinit var dataList: ArrayList<UserData>
    lateinit var titleList: ArrayList<String>
    lateinit var map: HashMap<String, ArrayList<String>>
    lateinit var arrayListData: ArrayList<ForUserData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        MyShare.init(this)
        CollectionData()
        CollectionDegreeList()
        btn_save.setOnClickListener {
            SavearrayListData()
        }

    }

    private fun SavearrayListData() {
        val hashSet = HashSet<String>()
        var boolean = false
        val name = edt_todoName.text.toString().trim()
        val description = edt_todoDescription.text.toString().trim()
        val createData = edt_todoCreateData.text.toString().trim()
        val deadline = edt_todoDeadline.text.toString().trim()
        val degree = Object.forDegree

        for (i in arrayListData) {
            hashSet.add(i.todoName)
        }
        boolean = hashSet.add(name)
        if (boolean) {
            arrayListData.add(
                ForUserData(
                    "Open",
                    name,
                    description,
                    degree,
                    createData,
                    deadline
                )
            )
            dataList[0].arrayListData = arrayListData
            MyShare.dataList = dataList
            edt_todoCreateData.text!!.clear()
            edt_todoDeadline.text!!.clear()
            edt_todoName.text!!.clear()
            edt_todoDescription.text!!.clear()
            CollectionDegreeList()
            Toast.makeText(this, "Save", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(
                this,
                "The plan with this name is already available, please try again by renaming the plan",
                Toast.LENGTH_SHORT
            ).show()

        }
    }

    private fun CollectionDegreeList() {
        val arrayList = ArrayList<DegreeClass>()
        arrayList.add(DegreeClass("Urgent", R.drawable.ic_red_flag))
        arrayList.add(DegreeClass("High", R.drawable.ic_yellow_flag))
        arrayList.add(DegreeClass("Normal", R.drawable.ic_grean_flag))
        arrayList.add(DegreeClass("Low", R.drawable.ic_baseline_flag_24))
        val adapter = DegreeAdapter(this, arrayList)
        spinner_degree.adapter = adapter
        spinner_degree.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Object.forDegree =
                    arrayList[position].string.toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    private fun CollectionData() {
        dataList = ArrayList()
        titleList = ArrayList()
        map = HashMap()
        arrayListData = ArrayList()
        dataList.addAll(MyShare.dataList!!)
        titleList = dataList[0].titleList
        map = dataList[0].map
        arrayListData = dataList[0].arrayListData
    }

    fun btn_Save() {
        btn_save.setOnClickListener {
            Toast.makeText(this, "SAVE", Toast.LENGTH_SHORT).show()}
    }
}