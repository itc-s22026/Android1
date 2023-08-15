package jp.ac.it_college.std.s22026.fragmentsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import jp.ac.it_college.std.s22026.fragmentsample.databinding.FragmentMenuListBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * メニュー一覧を表示するためのフラグメント
 */
class MenuListFragment : Fragment() {
    // Bindingクラスのインスタンスを入れておくプロパティ(Nullable)
    private var _binding: FragmentMenuListBinding? = null
    // Activity のときと同じように binding を使うための工夫
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.menuList.apply {
            adapter = MenuAdapter(teishokuList)
            val manager = LinearLayoutManager(context)
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(context, manager.orientation))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}