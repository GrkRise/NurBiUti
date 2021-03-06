package com.rizzhivaykini.nurbiuti.Fragments;

import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import com.dpizarro.autolabel.library.AutoLabelUI;
import com.dpizarro.autolabel.library.AutoLabelUISettings;
import com.rizzhivaykini.nurbiuti.Adapters.BubblesCardAdapter;
import com.rizzhivaykini.nurbiuti.Classes.Cheeses;
import com.rizzhivaykini.nurbiuti.Entities.Bubble;
import com.rizzhivaykini.nurbiuti.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private AutoLabelUI cloudUI;


    public BookingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookingFragment newInstance(String param1, String param2) {
        BookingFragment fragment = new BookingFragment();
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
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_booking, container, false);

        TimePicker timePicker = (TimePicker) view.findViewById(R.id.time);
        timePicker.setIs24HourView(true);

        EditText editText_phone = (EditText) view.findViewById(R.id.phone);

        editText_phone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        cloudUI = (AutoLabelUI) view.findViewById(R.id.clouds);
        AutoLabelUISettings autoLabelUISettings = new AutoLabelUISettings.Builder()
                .withMaxLabels(100)
                .withIconCross(R.drawable.cross)
                .withLabelsClickables(false)
                .withShowCross(true)
                .withBackgroundResource(R.drawable.back_card_dpurple)
                .withTextColor(android.R.color.white)
                .withTextSize(R.dimen.cloud_title_size)
                .withLabelPadding(R.dimen.padding_label_view)
                .build();
        cloudUI.setSettings(autoLabelUISettings);

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.add_cloud);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cloudUI.addLabel("text");
                Random random = new Random();
                TypedArray backs = view.getResources().obtainTypedArray(R.array.backs);
                cloudUI.setBackgroundResource(backs.getResourceId(random.nextInt(backs.length()),
                        R.drawable.back_card_dpurple));
            }
        });



//        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.bubbles);
//        setupRecyclerView(recyclerView);

        return view;
    }



    public void setupRecyclerView(RecyclerView recyclerView){
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 10));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new BubblesCardAdapter(getRandomSubList(Cheeses.sCheeseString, 30)));

    }

    private List<Bubble> getRandomSubList(String[] strings, int amount){
        ArrayList<Bubble> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount){
            Bubble bubble = new Bubble();
            bubble.setTitle(strings[random.nextInt(strings.length)]);
            list.add(bubble);
        }
        return list;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
