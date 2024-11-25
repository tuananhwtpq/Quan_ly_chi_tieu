package com.example.test_btl;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SourceFragment extends Fragment {

    private RecyclerView recyclerView;
    private FloatingActionButton fabAddSource;
    private SourceAdapter sourceAdapter;
    private List<Source> sourceList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SourceFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SourceFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SourceFragment newInstance(String param1, String param2) {
        SourceFragment fragment = new SourceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_source, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        fabAddSource = view.findViewById(R.id.fabAddSource);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        sourceList = new ArrayList<>();
        sourceList.add(new Source("Lương", 1000000, "Công ty"));
        sourceList.add(new Source("Tiết kiệm", 500000, "Ngân hàng"));
        sourceList.add(new Source("Bán hàng", 200000, "Cửa hàng"));

        sourceAdapter = new SourceAdapter(sourceList);
        recyclerView.setAdapter(sourceAdapter);

        fabAddSource.setOnClickListener(v -> {

            showAddSourceDialog();
        });

        return view;
    }
    private void showAddSourceDialog() {
        AddSourceDialogFragment dialog = new AddSourceDialogFragment();
        dialog.show(getParentFragmentManager(), "AddSourceDialog");
    }

    public void addSource(Source source) {
        sourceList.add(source);
        sourceAdapter.notifyItemInserted(sourceList.size() - 1);
    }
}