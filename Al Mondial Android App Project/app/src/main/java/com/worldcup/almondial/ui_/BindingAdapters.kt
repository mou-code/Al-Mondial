package com.worldcup.almondial.ui_

import android.icu.number.NumberFormatter.with
import android.view.KeyCharacterMap.load
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.worldcup.almondial.R
import java.lang.System.load

@BindingAdapter("TeamLogo")
fun bindTeamLogo(imageView: ImageView, TeamName: String) {
    when(TeamName){
        "Argentina" ->  imageView.setImageResource(R.drawable.arg)
        "France" ->  imageView.setImageResource(R.drawable.frn)
        "Brazil" ->  imageView.setImageResource(R.drawable.brz)
        "Germany" ->  imageView.setImageResource(R.drawable.gmn)
    }
}

@BindingAdapter("IntToString")
fun bindIntText(textView: TextView, integer: Int) {
    textView.text = integer.toString()
}
//
//@BindingAdapter("asteroidStatusImage")
//fun bindDetailsStatusImage(imageView: ImageView, isHazardous: Boolean) {
//    if (isHazardous) {
//        imageView.setImageResource(R.drawable.asteroid_hazardous)
//    } else {
//        imageView.setImageResource(R.drawable.asteroid_safe)
//    }
//}
//
//@BindingAdapter("astronomicalUnitText")
//fun bindTextViewToAstronomicalUnit(textView: TextView, number: Double) {
//    val context = textView.context
//    textView.text = String.format(context.getString(R.string.astronomical_unit_format), number)
//}
//
//@BindingAdapter("kmUnitText")
//fun bindTextViewToKmUnit(textView: TextView, number: Double) {
//    val context = textView.context
//    textView.text = String.format(context.getString(R.string.km_unit_format), number)
//}
//
//@BindingAdapter("velocityText")
//fun bindTextViewToDisplayVelocity(textView: TextView, number: Double) {
//    val context = textView.context
//    textView.text = String.format(context.getString(R.string.km_s_unit_format), number)
//}
//
//
//@BindingAdapter("url")
//fun bindImage(imgView: ImageView, imgUrl: String?) {
//    imgUrl?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        Picasso.get().load(imgUri).into(imgView);
//    }
//}
//
//
//@BindingAdapter("NetworkError")
//fun NetworkError(imgView: ImageView, status: MainViewModel.Status) {
//   when(status){
//       MainViewModel.Status.ERROR ->{
//           imgView.visibility = View.VISIBLE
//           imgView.setImageResource(R.drawable.ic_baseline_wifi_off_24)
//   }
//       else -> imgView.visibility = View.GONE
//       }
//   }
//
//
//@BindingAdapter("Loading")
//fun Loading(view: View, status: MainViewModel.Status) {
//
//    when(status){
//        MainViewModel.Status.LOADING -> {
//            view.visibility = View.VISIBLE
//        }
//        else -> view.visibility = View.GONE
//    }
//}
