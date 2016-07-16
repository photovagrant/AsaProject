package com.example.jason.kyudo_record_test1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView resultlist;
    Context ctx;
    resultclass mResultclass;
    ArrayList<result> results=new  ArrayList<result>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultlist = (RecyclerView) findViewById(R.id.recycleview);
         ctx=this;

        results.add(new result("Note1"));
        results.add(new result("Note2"));
        results.add(new result("Note3"));

        mResultclass=new resultclass(ctx,results);

        StaggeredGridLayoutManager  mLayoutManager = new StaggeredGridLayoutManager(
                1,StaggeredGridLayoutManager.VERTICAL
        );

        resultlist.setLayoutManager(mLayoutManager);
        resultlist.setAdapter(mResultclass);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                results.remove(1);
                mResultclass.setArr(results);
                mResultclass.notifyDataSetChanged();

            }
        });


    }

    private class resultclass extends RecyclerView.Adapter <RecyclerView.ViewHolder> {

        ArrayList<result> results=new  ArrayList<result>();

        Context ctx;
        public  resultclass(Context ctx,ArrayList<result> results){

            this.results=results;
            this.ctx=ctx;


        }

        public void setArr(ArrayList<result> results){this.results=results;}

        public class SmallViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            ImageView imageView1;
            ImageView imageView2;
            ImageView imageView3;
            ImageView playbackImg;
            TextView textView;
            VideoView mvideoView;

            public SmallViewHolder(View view) {
                super(view);

                imageView=(ImageView) view.findViewById(R.id.imageView);
                imageView1=(ImageView) view.findViewById(R.id.imageView1);
                imageView2=(ImageView) view.findViewById(R.id.imageView2);
                imageView3=(ImageView) view.findViewById(R.id.imageView3);
                playbackImg=(ImageView) view.findViewById(R.id.playback1);
                textView=(TextView) view.findViewById(R.id.textView);

                imageView.setTag(Integer.valueOf(R.drawable.kyudoicon01));
                imageView1.setTag(Integer.valueOf(R.drawable.kyudoicon01));
                imageView2.setTag(Integer.valueOf(R.drawable.kyudoicon01));
                imageView3.setTag(Integer.valueOf(R.drawable.kyudoicon01));

                imageView.setOnClickListener(test1);
                imageView1.setOnClickListener(test1);
                imageView2.setOnClickListener(test1);
                imageView3.setOnClickListener(test1);
                playbackImg.setOnClickListener ( test2 );
            }
            public  View.OnClickListener test2 = new View.OnClickListener() {
                @Override

                public void onClick(View view) {

                     mvideoView= (VideoView) findViewById ( R.id.videoview );
                    //Uri uriaddr = Uri.parse ( "http://bffmedia.com/bigbunny.mp4" );
//                  //  Intent it = new Intent ( Intent.ACTION_VIEW, uriaddr );
                    //MediaController mediaController = new MediaController ();
                    //mvideoView.setVideoURI (vidUri  );
                    MediaController mediaController = new MediaController (ctx);
                    mediaController.setAnchorView(mvideoView);
                    String videoToPlay = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
                    Uri videoUri = Uri.parse(videoToPlay);
                    mvideoView.setMediaController (mediaController);
                    mvideoView.setVideoURI(videoUri);
                    //mvideoView.setVideoPath("/storage/509B-6411/HTC_MakeMoreSpace/Gallery/VIDEO0005.mp4");
//                    mvideoView.requestFocus();
                    mvideoView.start();
                }

            };

            public  View.OnClickListener test1  = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //imageView1.setVisibility(View.GONE);
                    ImageView ImageViewX = (ImageView) view;
                    int drawable = (Integer) ImageViewX.getTag();
                    Toast.makeText(getApplicationContext(), drawable,
                            Toast.LENGTH_SHORT).show();

                    switch(drawable)
                    {
                        case R.drawable.kyudoicon01:
                            ImageViewX.setImageResource(R.drawable.kyudoicon02);
                            ImageViewX.setTag(R.drawable.kyudoicon02);
                            break;
                        case R.drawable.kyudoicon02:
                            ImageViewX.setImageResource(R.drawable.kyudoicon03);
                            ImageViewX.setTag(R.drawable.kyudoicon03);
                            break;
                        case R.drawable.kyudoicon03:
                            ImageViewX.setImageResource(R.drawable.kyudoicon04);
                            ImageViewX.setTag(R.drawable.kyudoicon04);
                            break;
                        case R.drawable.kyudoicon04:
                            ImageViewX.setImageResource(R.drawable.kyudoicon01);
                            ImageViewX.setTag(R.drawable.kyudoicon01);
                            break;

                    }//end of s
                    //imageView.setImageResource(R.drawable.kyudoicon04);
                }
            };
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            return new SmallViewHolder(LayoutInflater.from(ctx).inflate(R.layout.item,parent,false));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            ((SmallViewHolder)holder).textView.setText(results.get(position).getName());



        }

        @Override
        public int getItemCount() {
            return results.size();
        }
    }


}
