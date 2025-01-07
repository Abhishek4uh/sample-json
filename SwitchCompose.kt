@Composable
private fun FirstCard(
    lockCommand: (String) -> Unit,
    mobCommand:(String)->Unit,
    canIoStatusData:CanIoStatusData?){


    val isSwitchEnabled = canIoStatusData != null
    var isLockedChecked by remember { mutableStateOf(canIoStatusData?.lock == 1) }
    var isMobiliseChecked by remember { mutableStateOf(canIoStatusData?.mobilize == 1) }



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){

        Card(
            modifier = Modifier.fillMaxWidth().padding(start = 6.dp, end = 6.dp, bottom = 12.dp),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)){


            Column (
                modifier = Modifier.fillMaxWidth().padding(12.dp)){

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){

                    Icon(
                        painter = painterResource(id = R.drawable.lock_ic),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )
                    Spacer(
                        modifier = Modifier.width(6.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.lock),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Switch(
                        modifier = Modifier.scale(0.7f),
                        thumbContent = {
                            Box(modifier = Modifier.size(4.dp).clip(CircleShape))
                        },
                        checked = isLockedChecked,
                        enabled = isSwitchEnabled,
                        onCheckedChange = {isChecked->
                            if (isSwitchEnabled){
                                isLockedChecked = isChecked
                                if (isChecked) {
                                    //Lock
                                    lockCommand("io_board_kle_lock")
                                }
                                else {
                                    //Unlock
                                    lockCommand("io_board_kle_unlock")
                                }
                            }
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = SwitchEnable,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = SwitchDisable,
                            checkedThumbColor = Color.White,
                            uncheckedBorderColor = Transparent,
                            disabledUncheckedTrackColor = SwitchDisable,
                            disabledUncheckedThumbColor = Color.White,
                            disabledUncheckedBorderColor = Transparent
                        )
                    )
                }



                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 22.dp),
                    color = QCDivider
                )



                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically){

                    Icon(
                        painter = painterResource(id = R.drawable.key_ic),
                        contentDescription = null,
                        tint = Color.Unspecified
                    )

                    Spacer(
                        modifier = Modifier.width(6.dp)
                    )

                    Text(
                        text = stringResource(id = R.string.mobilise),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.weight(1f))

                    Switch(
                        modifier = Modifier.scale(0.7f)
                        ,thumbContent = {
                            Box(modifier = Modifier.size(4.dp).clip(CircleShape))
                        },
                        enabled = isSwitchEnabled,
                        checked = isMobiliseChecked,
                        onCheckedChange = {isChecked->
                            isMobiliseChecked = isChecked
                            if (isSwitchEnabled){
                                isMobiliseChecked = isChecked
                                if(isChecked){
                                    //Mobilize
                                    mobCommand("io_board_mobilize")
                                }
                                else {
                                    //Immobilize
                                    mobCommand("io_board_immobilize")
                                }
                            }
                        },
                        colors = SwitchDefaults.colors(
                            checkedTrackColor = SwitchEnable,
                            uncheckedThumbColor = Color.White,
                            uncheckedTrackColor = SwitchDisable,
                            checkedThumbColor = Color.White,
                            uncheckedBorderColor = Transparent,
                            disabledUncheckedTrackColor = SwitchDisable,
                            disabledUncheckedThumbColor = Color.White,
                            disabledUncheckedBorderColor = Transparent
                        )
                    )
                }
            }
        }
    }
}
