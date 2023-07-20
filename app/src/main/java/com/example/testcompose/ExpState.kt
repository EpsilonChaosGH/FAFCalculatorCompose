package com.example.testcompose

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.example.testcompose.ui.theme.BlueUef
import com.example.testcompose.ui.theme.GreenAeon
import com.example.testcompose.ui.theme.RedCybran
import com.example.testcompose.ui.theme.YellowSeraphim

enum class ExpState(
    @DrawableRes val iconResId: Int,
    @StringRes val costResId: Int,
    @StringRes val titleResId: Int,
    @StringRes val factionColor: Color
) {
    COST_250200(R.drawable.paragon, R.string.paragon_cost, R.string.paragon, GreenAeon),
    COST_202500(R.drawable.salvation, R.string.salvation_cost, R.string.salvation, GreenAeon),
    COST_73200(R.drawable.emissary, R.string.emissary_cost, R.string.emissary, GreenAeon),
    COST_45500(R.drawable.czar, R.string.czar_cost, R.string.czar, GreenAeon),
    COST_27500(R.drawable.colossus, R.string.colossus_cost, R.string.colossus, GreenAeon),
    COST_22000(R.drawable.tempest, R.string.tempest_cost, R.string.tempest, GreenAeon),

    COST_224775(R.drawable.mavor, R.string.mavor_cost, R.string.mavor, BlueUef),
    COST_72000(R.drawable.duke, R.string.duke_cost, R.string.duke, BlueUef),
    COST_36000(R.drawable.novax, R.string.novax_cost, R.string.novax, BlueUef),
    COST_28000(R.drawable.fatboy, R.string.fatboy_cost, R.string.fatboy, BlueUef),
    COST_12000(R.drawable.atlantis, R.string.atlantis_cost, R.string.atlantis, BlueUef),

    COST_220000(R.drawable.scathis, R.string.scathis_cost, R.string.scathis, RedCybran),
    COST_69600(R.drawable.disruptor, R.string.disruptor_cost, R.string.disruptor, RedCybran),
    COST_37500(R.drawable.megalith, R.string.megalith_cost, R.string.megalith, RedCybran),
    COST_34000(R.drawable.soulripper, R.string.soulripper_cost, R.string.soulripper, RedCybran),
    COST_20000(R.drawable.monkeylord, R.string.monkeylord_cost, R.string.monkeylord, RedCybran),

    COST_187650(R.drawable.yolonaoss, R.string.yolonaoss_cost, R.string.yolonaoss, YellowSeraphim),
    COST_78000(R.drawable.hovatham, R.string.hovatham_cost, R.string.hovatham, YellowSeraphim),
    COST_48000(R.drawable.ahwassa, R.string.ahwassa_cost, R.string.ahwassa, YellowSeraphim),
    COST_26500(R.drawable.ythotha, R.string.ythotha_cost, R.string.ythotha, YellowSeraphim);

    companion object {
        fun findImageByCoast(cost: Int): Int {
            for (exp in ExpState.values()) {
                if (exp.toString().equals("COST_$cost", true))
                    return exp.iconResId
            }
            return R.drawable.mass_icon
        }

        fun getList(): List<ExpState> {
            return enumValues<ExpState>().toList()
        }
    }
}