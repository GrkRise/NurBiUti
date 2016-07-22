package com.rizzhivaykini.nurbiuti.Fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rizzhivaykini.nurbiuti.Adapters.ImagePagerAdapter;
import com.rizzhivaykini.nurbiuti.R;
import com.rizzhivaykini.nurbiuti.utils.ListUtils;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SliderFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SliderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SliderFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private AutoScrollViewPager viewPager;
    private List<Integer> imageIdList;

    public SliderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SliderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SliderFragment newInstance(String param1, String param2) {
        SliderFragment fragment = new SliderFragment();
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
        View root = inflater.inflate(R.layout.fragment_slider, container, false);

        viewPager = (AutoScrollViewPager) root.findViewById(R.id.view_pager);

        imageIdList = new ArrayList<Integer>();
        imageIdList.add(R.drawable.cheese_1);
        imageIdList.add(R.drawable.cheese_2);
        imageIdList.add(R.drawable.cheese_3);
        imageIdList.add(R.drawable.cheese_4);
        imageIdList.add(R.drawable.cheese_5);

        viewPager.setAdapter(new ImagePagerAdapter(getContext(), imageIdList).setInfiniteLoop(true));

        viewPager.setInterval(100);
        viewPager.startAutoScroll();
        viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % ListUtils.getSize(imageIdList));
        viewPager.setCycle(true);

        return root;
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

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        viewPager.stopAutoScroll();
    }

    @Override
    public void onResume() {
        super.onResume();
        viewPager.stopAutoScroll();
    }
}
