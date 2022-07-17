package stepn.sidekick.stepnsidekick;

import static stepn.sidekick.stepnsidekick.MainActivity.ads;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Information about the app, 'remove ads' button, option to donate
 *
 * @author Bob Godfrey
 * @version 1.3.2 Updated app layout to use fragments instead of activities for menu items
 *
 */

public class AboutFrag extends Fragment {

    Button emailButton, solButton, bnbButton;
    ImageButton removeAdsButton;
    ImageView removeAdsShadow;
    TextView emailTextView, removeAdsTextView, removeAdsShadowTextView;
    ClipboardManager clipboard;

    public AboutFrag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        clipboard = (ClipboardManager) requireActivity().getSystemService(Context.CLIPBOARD_SERVICE);

    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        emailButton = view.findViewById(R.id.emailButton);
        solButton = view.findViewById(R.id.solButton);
        bnbButton = view.findViewById(R.id.bnbButton);
        emailTextView = view.findViewById(R.id.contactEmailTextView);

        removeAdsButton = view.findViewById(R.id.removeAdsButton);
        removeAdsTextView = view.findViewById(R.id.removeAdsTextView);
        removeAdsShadow = view.findViewById(R.id.removeAdsShadowButton);
        removeAdsShadowTextView = view.findViewById(R.id.removeAdsShadowTextView);

        if (ads) {
            removeAdsButton.setVisibility(View.VISIBLE);
            removeAdsShadow.setVisibility(View.VISIBLE);
            removeAdsTextView.setVisibility(View.VISIBLE);
            removeAdsShadowTextView.setVisibility(View.VISIBLE);
        } else {
            removeAdsButton.setVisibility(View.GONE);
            removeAdsShadow.setVisibility(View.GONE);
            removeAdsTextView.setVisibility(View.GONE);
            removeAdsShadowTextView.setVisibility(View.GONE);
        }

        removeAdsButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        removeAdsButton.setVisibility(View.INVISIBLE);
                        removeAdsTextView.setVisibility(View.INVISIBLE);
                        removeAdsShadow.setImageResource(R.drawable.start_button);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        removeAdsButton.setVisibility(View.VISIBLE);
                        removeAdsTextView.setVisibility(View.VISIBLE);
                        removeAdsShadow.setImageResource(R.drawable.start_button_shadow);
                        break;
                }
                return false;
            }
        });

        removeAdsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
            }
        });

        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clip = ClipData.newPlainText("email", getString(R.string.contact_email));
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getContext(), getString(R.string.email_copied), Toast.LENGTH_SHORT).show();
            }
        });

        emailButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        emailTextView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.energy_blue_darker));
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        emailTextView.setTextColor(ContextCompat.getColor(requireActivity(), R.color.luck_socket_border));
                        break;
                }
                return false;
            }
        });

        solButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clip = ClipData.newPlainText("email", getString(R.string.solana_chain));
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getContext(), getString(R.string.sol_address_copied), Toast.LENGTH_SHORT).show();
            }
        });

        solButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        solButton.setAlpha(0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        solButton.setAlpha(0.0f);
                        break;
                }
                return false;
            }
        });

        bnbButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipData clip = ClipData.newPlainText("email", getString(R.string.bnb_chain));
                clipboard.setPrimaryClip(clip);

                Toast.makeText(getActivity(), getString(R.string.bnb_address_copied), Toast.LENGTH_SHORT).show();
            }
        });

        bnbButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        bnbButton.setAlpha(0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
                        bnbButton.setAlpha(0.0f);
                        break;
                }
                return false;
            }
        });

        return view;
    }
}