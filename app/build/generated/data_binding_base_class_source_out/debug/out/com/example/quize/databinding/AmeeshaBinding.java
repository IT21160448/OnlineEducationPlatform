// Generated by view binder compiler. Do not edit!
package com.example.quize.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.quize.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AmeeshaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button3;

  @NonNull
  public final RecyclerView cardRecyclerView;

  @NonNull
  public final RecyclerView cardRecyclerView2;

  @NonNull
  public final EditText editTextTextPersonName12;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView23;

  private AmeeshaBinding(@NonNull ConstraintLayout rootView, @NonNull Button button3,
      @NonNull RecyclerView cardRecyclerView, @NonNull RecyclerView cardRecyclerView2,
      @NonNull EditText editTextTextPersonName12, @NonNull ImageView imageView,
      @NonNull ImageView imageView2, @NonNull TextView textView16, @NonNull TextView textView23) {
    this.rootView = rootView;
    this.button3 = button3;
    this.cardRecyclerView = cardRecyclerView;
    this.cardRecyclerView2 = cardRecyclerView2;
    this.editTextTextPersonName12 = editTextTextPersonName12;
    this.imageView = imageView;
    this.imageView2 = imageView2;
    this.textView16 = textView16;
    this.textView23 = textView23;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AmeeshaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AmeeshaBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.ameesha, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AmeeshaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.cardRecyclerView;
      RecyclerView cardRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (cardRecyclerView == null) {
        break missingId;
      }

      id = R.id.cardRecyclerView2;
      RecyclerView cardRecyclerView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardRecyclerView2 == null) {
        break missingId;
      }

      id = R.id.editTextTextPersonName12;
      EditText editTextTextPersonName12 = ViewBindings.findChildViewById(rootView, id);
      if (editTextTextPersonName12 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = ViewBindings.findChildViewById(rootView, id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = ViewBindings.findChildViewById(rootView, id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView23;
      TextView textView23 = ViewBindings.findChildViewById(rootView, id);
      if (textView23 == null) {
        break missingId;
      }

      return new AmeeshaBinding((ConstraintLayout) rootView, button3, cardRecyclerView,
          cardRecyclerView2, editTextTextPersonName12, imageView, imageView2, textView16,
          textView23);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}