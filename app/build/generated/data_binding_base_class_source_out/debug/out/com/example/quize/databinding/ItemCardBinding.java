// Generated by view binder compiler. Do not edit!
package com.example.quize.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.quize.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final Button button4;

  @NonNull
  public final Button button5;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView18;

  @NonNull
  public final TextView textView19;

  @NonNull
  public final TextView textView20;

  @NonNull
  public final TextView textView21;

  @NonNull
  public final TextView textView22;

  private ItemCardBinding(@NonNull CardView rootView, @NonNull Button button4,
      @NonNull Button button5, @NonNull CardView cardView, @NonNull TextView textView17,
      @NonNull TextView textView18, @NonNull TextView textView19, @NonNull TextView textView20,
      @NonNull TextView textView21, @NonNull TextView textView22) {
    this.rootView = rootView;
    this.button4 = button4;
    this.button5 = button5;
    this.cardView = cardView;
    this.textView17 = textView17;
    this.textView18 = textView18;
    this.textView19 = textView19;
    this.textView20 = textView20;
    this.textView21 = textView21;
    this.textView22 = textView22;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button4;
      Button button4 = ViewBindings.findChildViewById(rootView, id);
      if (button4 == null) {
        break missingId;
      }

      id = R.id.button5;
      Button button5 = ViewBindings.findChildViewById(rootView, id);
      if (button5 == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = ViewBindings.findChildViewById(rootView, id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = ViewBindings.findChildViewById(rootView, id);
      if (textView18 == null) {
        break missingId;
      }

      id = R.id.textView19;
      TextView textView19 = ViewBindings.findChildViewById(rootView, id);
      if (textView19 == null) {
        break missingId;
      }

      id = R.id.textView20;
      TextView textView20 = ViewBindings.findChildViewById(rootView, id);
      if (textView20 == null) {
        break missingId;
      }

      id = R.id.textView21;
      TextView textView21 = ViewBindings.findChildViewById(rootView, id);
      if (textView21 == null) {
        break missingId;
      }

      id = R.id.textView22;
      TextView textView22 = ViewBindings.findChildViewById(rootView, id);
      if (textView22 == null) {
        break missingId;
      }

      return new ItemCardBinding((CardView) rootView, button4, button5, cardView, textView17,
          textView18, textView19, textView20, textView21, textView22);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}