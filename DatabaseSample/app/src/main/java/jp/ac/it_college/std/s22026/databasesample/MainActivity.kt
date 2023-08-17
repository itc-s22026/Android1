package jp.ac.it_college.std.s22026.databasesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import jp.ac.it_college.std.s22026.databasesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // RecyclerView の初期化
        initList(binding.IvCocktail)
    }

    private fun initList(list: RecyclerView) {
        val data = resources.getStringArray(R.array.lv_cooktail_list)
        val adapter = CocktailAdapter(data.toList()) { pos, name ->
            // 選択されたカクテル名を画面上に表示
            binding.tvCocktailName.text = name
        }
        val manager = LinearLayoutManager(this)
        list.adapter = adapter
        list.layoutManager = manager
        list.addItemDecoration(
            DividerItemDecoration(this, manager.orientation)
        )
    }
}


