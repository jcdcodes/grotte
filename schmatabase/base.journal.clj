(grotte.data/create-domain :note) ;1
(grotte.data/add-column :note :body :editable-text) ;1
(grotte.data/add-column :note :date :date) ;2
(grotte.data/make-row :note :id "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75") ;3
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :body "Monkey") ;4
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :body "Monkeys") ;5
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "02/01/2013") ;6
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "02/01/2013") ;7
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :body "Monkeys! Drums!") ;8
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :body "Monkeys! Drums! (Dum ditty dum ditty dum dum dum)") ;9
(grotte.data/make-row :note :id "ae3b9b2a-0842-429c-8d1f-378ee65d2f5b") ;10
(grotte.data/update-row-by-idstring :note "ae3b9b2a-0842-429c-8d1f-378ee65d2f5b" :body "Millions of fingers; millions of thumbs") ;11
(grotte.data/update-row-by-idstring :note "ae3b9b2a-0842-429c-8d1f-378ee65d2f5b" :date "02/03/2013") ;12
(grotte.data/make-row :note :id "10e22af8-7db8-437c-89ee-2ef75db6db42") ;13
(grotte.data/update-row-by-idstring :note "10e22af8-7db8-437c-89ee-2ef75db6db42" :body "THis is a third row. I even typed it wrong.") ;14
(grotte.data/create-domain :detail) ;15
(grotte.data/make-row :detail :id "6f09924b-087b-4643-b628-bb5d09b7bb79") ;16
(grotte.data/add-column :detail :litany :editable-text) ;17
(grotte.data/add-column :detail :note :note) ;18
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :litany "The trouble with typing things wrong is that they inevitably need correcting, and keeping track of the list of corrections can be mighty daunting.") ;19
(grotte.data/create-domain :state) ;20
(grotte.data/make-row :state :id "45f154c4-5e29-478f-87f3-854b297424d0") ;22
(grotte.data/drop-column :state :name) ;23
(grotte.data/add-column :state :name :editable-text) ;24
(grotte.data/update-row-by-idstring :state "45f154c4-5e29-478f-87f3-854b297424d0" :name "Alabama") ;25
(grotte.data/add-column :state :abbr :editable-text) ;26
(grotte.data/update-row-by-idstring :state "45f154c4-5e29-478f-87f3-854b297424d0" :abbr "AL") ;27
(grotte.data/make-row :state :id "492e3396-198e-409a-9b62-f7dca6a13d46") ;28
(grotte.data/make-row :state :id "e2b9ef0f-5a38-4431-81d0-44c27787f0bd") ;29
(grotte.data/make-row :state :id "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;30
(grotte.data/make-row :state :id "f4326c2c-b360-4c3b-ada3-5467262c0411") ;31
(grotte.data/make-row :state :id "284411b3-703f-4283-b136-71118e98d63e") ;32
(grotte.data/make-row :state :id "0b3f0902-da3e-4e25-b794-1f018b770f5d") ;33
(grotte.data/make-row :state :id "834a5a7b-4936-4243-936b-19ec9681832d") ;34
(grotte.data/make-row :state :id "ab1aaed6-340d-483c-9547-3db4cafb876c") ;35
(grotte.data/make-row :state :id "9cafbe3b-7d84-49dd-a5a8-613fbdca435e") ;36
(grotte.data/make-row :state :id "9f9943c3-a8a4-45d7-af83-dd0840c7048f") ;37
(grotte.data/make-row :state :id "60f3e6f9-90c5-42b2-b9bc-05feec587202") ;38
(grotte.data/make-row :state :id "4edf7001-79a1-4d14-af51-0ec1dbaa48e7") ;39
(grotte.data/make-row :state :id "055dbf73-0bba-4f2d-8194-3d628d573ccc") ;40
(grotte.data/make-row :state :id "31cc1692-0142-4927-9fb0-c2af64adf822") ;41
(grotte.data/make-row :state :id "48ab441c-3f53-4ec6-ae48-83535654e8c6") ;42
(grotte.data/make-row :state :id "b808d307-4dd9-4e4c-af68-ee734464bc93") ;43
(grotte.data/make-row :state :id "3e833008-b710-4efc-b455-d659e04e108a") ;44
(grotte.data/make-row :state :id "c47cba63-85a8-431d-b590-3063843340dc") ;45
(grotte.data/make-row :state :id "71188e74-0971-43de-98a6-1740e0cec08b") ;46
(grotte.data/make-row :state :id "a2f30930-ef53-4678-96bb-e9f987a0c909") ;47
(grotte.data/make-row :state :id "97bf6328-d56a-4c2b-ad57-596ae458c891") ;48
(grotte.data/make-row :state :id "f7f9fc17-c84d-48c9-9e91-a54844ab0925") ;49
(grotte.data/make-row :state :id "522d3d4c-4410-4966-8f81-ce678d584156") ;50
(grotte.data/make-row :state :id "78178e7c-eaeb-4924-8af6-23d3100b8373") ;51
(grotte.data/make-row :state :id "8a69cf0b-a998-4f32-a26a-b83b0a5c6c39") ;52
(grotte.data/make-row :state :id "5b783f80-3f50-453e-b272-6bca50051052") ;53
(grotte.data/make-row :state :id "bd4b62aa-ca36-4577-8c47-9cc039fcf582") ;54
(grotte.data/make-row :state :id "5052e7d2-685c-4965-83e5-3cf3447f2df3") ;55
(grotte.data/make-row :state :id "fdd90033-671f-4c37-98b0-1a5a3c3fbb91") ;56
(grotte.data/make-row :state :id "9c982610-0ac9-4733-bca7-077eb2ccc82f") ;57
(grotte.data/make-row :state :id "edcd69d8-55fb-4cba-a86e-333d913c5101") ;58
(grotte.data/make-row :state :id "3a0ea47f-c9e3-45c2-9e81-a1600e8e57e1") ;59
(grotte.data/make-row :state :id "c8991442-928a-40a8-9ff9-c712e937d3b5") ;60
(grotte.data/make-row :state :id "0accd144-9697-4338-86bb-80f054d447d7") ;61
(grotte.data/update-row-by-idstring :state "492e3396-198e-409a-9b62-f7dca6a13d46" :abbr "AK") ;62
(grotte.data/update-row-by-idstring :state "e2b9ef0f-5a38-4431-81d0-44c27787f0bd" :abbr "AZ") ;63
(grotte.data/update-row-by-idstring :state "53f37b31-8116-4a50-8a80-d4fbc81ae828" :abbr "AK") ;64
(grotte.data/update-row-by-idstring :state "53f37b31-8116-4a50-8a80-d4fbc81ae828" :abbr "AR") ;65
(grotte.data/update-row-by-idstring :state "492e3396-198e-409a-9b62-f7dca6a13d46" :name "Alaska") ;66
(grotte.data/update-row-by-idstring :state "e2b9ef0f-5a38-4431-81d0-44c27787f0bd" :name "Arizona") ;67
(grotte.data/update-row-by-idstring :state "53f37b31-8116-4a50-8a80-d4fbc81ae828" :name "Arkansas") ;68
(grotte.data/update-row-by-idstring :state "f4326c2c-b360-4c3b-ada3-5467262c0411" :name "California") ;69
(grotte.data/update-row-by-idstring :state "284411b3-703f-4283-b136-71118e98d63e" :name "Colorado") ;70
(grotte.data/update-row-by-idstring :state "0b3f0902-da3e-4e25-b794-1f018b770f5d" :name "Connecticut") ;71
(grotte.data/update-row-by-idstring :state "834a5a7b-4936-4243-936b-19ec9681832d" :name "Delaware") ;72
(grotte.data/update-row-by-idstring :state "ab1aaed6-340d-483c-9547-3db4cafb876c" :name "Florida") ;73
(grotte.data/update-row-by-idstring :state "9cafbe3b-7d84-49dd-a5a8-613fbdca435e" :name "Georgia") ;74
(grotte.data/update-row-by-idstring :state "9f9943c3-a8a4-45d7-af83-dd0840c7048f" :name "Hawaii") ;75
(grotte.data/update-row-by-idstring :state "60f3e6f9-90c5-42b2-b9bc-05feec587202" :name "Idaho") ;76
(grotte.data/update-row-by-idstring :state "4edf7001-79a1-4d14-af51-0ec1dbaa48e7" :name "Illinois") ;77
(grotte.data/update-row-by-idstring :state "055dbf73-0bba-4f2d-8194-3d628d573ccc" :name "Indiana") ;78
(grotte.data/update-row-by-idstring :state "31cc1692-0142-4927-9fb0-c2af64adf822" :name "Iowa") ;79
(grotte.data/update-row-by-idstring :state "48ab441c-3f53-4ec6-ae48-83535654e8c6" :name "Kansas") ;80
(grotte.data/update-row-by-idstring :state "b808d307-4dd9-4e4c-af68-ee734464bc93" :name "Kentucky") ;81
(grotte.data/update-row-by-idstring :state "3e833008-b710-4efc-b455-d659e04e108a" :name "Louisiana") ;82
(grotte.data/update-row-by-idstring :state "c47cba63-85a8-431d-b590-3063843340dc" :name "Maine") ;83
(grotte.data/update-row-by-idstring :state "71188e74-0971-43de-98a6-1740e0cec08b" :name "Maryland") ;84
(grotte.data/update-row-by-idstring :state "f4326c2c-b360-4c3b-ada3-5467262c0411" :abbr "CA") ;85
(grotte.data/update-row-by-idstring :state "284411b3-703f-4283-b136-71118e98d63e" :abbr "CO") ;86
(grotte.data/update-row-by-idstring :state "0b3f0902-da3e-4e25-b794-1f018b770f5d" :abbr "CT") ;87
(grotte.data/update-row-by-idstring :state "834a5a7b-4936-4243-936b-19ec9681832d" :abbr "CE") ;88
(grotte.data/update-row-by-idstring :state "834a5a7b-4936-4243-936b-19ec9681832d" :abbr "DE") ;89
(grotte.data/update-row-by-idstring :state "ab1aaed6-340d-483c-9547-3db4cafb876c" :abbr "FL") ;90
(grotte.data/update-row-by-idstring :state "9cafbe3b-7d84-49dd-a5a8-613fbdca435e" :abbr "GA") ;91
(grotte.data/update-row-by-idstring :state "9f9943c3-a8a4-45d7-af83-dd0840c7048f" :abbr "HI") ;92
(grotte.data/update-row-by-idstring :state "60f3e6f9-90c5-42b2-b9bc-05feec587202" :abbr "ID") ;93
(grotte.data/update-row-by-idstring :state "4edf7001-79a1-4d14-af51-0ec1dbaa48e7" :abbr "IL") ;94
(grotte.data/update-row-by-idstring :state "055dbf73-0bba-4f2d-8194-3d628d573ccc" :abbr "IN") ;95
(grotte.data/update-row-by-idstring :state "31cc1692-0142-4927-9fb0-c2af64adf822" :abbr "IA") ;96
(grotte.data/update-row-by-idstring :state "48ab441c-3f53-4ec6-ae48-83535654e8c6" :abbr "KS") ;97
(grotte.data/update-row-by-idstring :state "b808d307-4dd9-4e4c-af68-ee734464bc93" :abbr "KY") ;98
(grotte.data/update-row-by-idstring :state "3e833008-b710-4efc-b455-d659e04e108a" :abbr "LA") ;99
(grotte.data/update-row-by-idstring :state "c47cba63-85a8-431d-b590-3063843340dc" :abbr "ME") ;100
(grotte.data/update-row-by-idstring :state "71188e74-0971-43de-98a6-1740e0cec08b" :abbr "MD") ;101
(grotte.data/update-row-by-idstring :state "a2f30930-ef53-4678-96bb-e9f987a0c909" :abbr "MA") ;102
(grotte.data/update-row-by-idstring :state "97bf6328-d56a-4c2b-ad57-596ae458c891" :abbr "MI") ;103
(grotte.data/update-row-by-idstring :state "f7f9fc17-c84d-48c9-9e91-a54844ab0925" :abbr "MN") ;104
(grotte.data/update-row-by-idstring :state "522d3d4c-4410-4966-8f81-ce678d584156" :abbr "MS") ;105
(grotte.data/update-row-by-idstring :state "78178e7c-eaeb-4924-8af6-23d3100b8373" :abbr "MO") ;106
(grotte.data/update-row-by-idstring :state "8a69cf0b-a998-4f32-a26a-b83b0a5c6c39" :abbr "MT") ;107
(grotte.data/update-row-by-idstring :state "5b783f80-3f50-453e-b272-6bca50051052" :abbr "NE") ;108
(grotte.data/update-row-by-idstring :state "bd4b62aa-ca36-4577-8c47-9cc039fcf582" :abbr "NV") ;109
(grotte.data/update-row-by-idstring :state "5052e7d2-685c-4965-83e5-3cf3447f2df3" :abbr "NH") ;110
(grotte.data/update-row-by-idstring :state "fdd90033-671f-4c37-98b0-1a5a3c3fbb91" :abbr "NJ") ;111
(grotte.data/update-row-by-idstring :state "9c982610-0ac9-4733-bca7-077eb2ccc82f" :abbr "NM") ;112
(grotte.data/update-row-by-idstring :state "edcd69d8-55fb-4cba-a86e-333d913c5101" :abbr "NY") ;113
(grotte.data/update-row-by-idstring :state "3a0ea47f-c9e3-45c2-9e81-a1600e8e57e1" :abbr "NC") ;114
(grotte.data/update-row-by-idstring :state "c8991442-928a-40a8-9ff9-c712e937d3b5" :abbr "ND") ;115
(grotte.data/update-row-by-idstring :state "0accd144-9697-4338-86bb-80f054d447d7" :abbr "OH") ;116
(grotte.data/update-row-by-idstring :state "0accd144-9697-4338-86bb-80f054d447d7" :name "Ohiao") ;117
(grotte.data/update-row-by-idstring :state "0accd144-9697-4338-86bb-80f054d447d7" :name "Ohio") ;118
(grotte.data/update-row-by-idstring :state "a2f30930-ef53-4678-96bb-e9f987a0c909" :name "Massachusetts") ;119
(grotte.data/update-row-by-idstring :state "97bf6328-d56a-4c2b-ad57-596ae458c891" :name "Michigan") ;120
(grotte.data/update-row-by-idstring :state "f7f9fc17-c84d-48c9-9e91-a54844ab0925" :name "Minnesota") ;121
(grotte.data/update-row-by-idstring :state "522d3d4c-4410-4966-8f81-ce678d584156" :name "Mississippi") ;122
(grotte.data/update-row-by-idstring :state "78178e7c-eaeb-4924-8af6-23d3100b8373" :name "Missouri") ;123
(grotte.data/update-row-by-idstring :state "8a69cf0b-a998-4f32-a26a-b83b0a5c6c39" :name "Montana") ;124
(grotte.data/update-row-by-idstring :state "5b783f80-3f50-453e-b272-6bca50051052" :name "Nebraska") ;125
(grotte.data/update-row-by-idstring :state "bd4b62aa-ca36-4577-8c47-9cc039fcf582" :name "Nevada") ;126
(grotte.data/update-row-by-idstring :state "5052e7d2-685c-4965-83e5-3cf3447f2df3" :name "New Hampshire") ;127
(grotte.data/update-row-by-idstring :state "fdd90033-671f-4c37-98b0-1a5a3c3fbb91" :name "New Jersey") ;128
(grotte.data/update-row-by-idstring :state "9c982610-0ac9-4733-bca7-077eb2ccc82f" :name "New Mexico") ;129
(grotte.data/update-row-by-idstring :state "edcd69d8-55fb-4cba-a86e-333d913c5101" :name "New York") ;130
(grotte.data/update-row-by-idstring :state "3a0ea47f-c9e3-45c2-9e81-a1600e8e57e1" :name "North Carolina") ;131
(grotte.data/update-row-by-idstring :state "c8991442-928a-40a8-9ff9-c712e937d3b5" :name "North Dakota") ;132
(grotte.data/add-column :note :state :state) ;133
(grotte.data/add-column :note :date :date) ;134
(grotte.data/drop-column :note :state) ;135
(grotte.data/drop-column :note :date) ;136
(grotte.data/add-column :note :date :date) ;137
(grotte.data/drop-column :note :body) ;138
(grotte.data/add-column :note :body :body) ;139
(grotte.data/update-row-by-idstring :note "10e22af8-7db8-437c-89ee-2ef75db6db42" :date "02/28/2013") ;140
(grotte.data/update-row-by-idstring :note "10e22af8-7db8-437c-89ee-2ef75db6db42" :date "02/28/2014") ;141
(grotte.data/make-row :state :id "dbdbfb63-3f9a-4f51-9258-331aa0e8caf4") ;1
(grotte.data/make-row :state :id "eb1d35e3-9bd7-4537-aba8-2997dafeca4a") ;2
(grotte.data/update-row-by-idstring :state "dbdbfb63-3f9a-4f51-9258-331aa0e8caf4" :abbr "OK") ;3
(grotte.data/update-row-by-idstring :state "eb1d35e3-9bd7-4537-aba8-2997dafeca4a" :abbr "OR") ;4
(grotte.data/make-row :state :id "fc6d4791-f2ca-4ebb-aa22-b9ab9a9a3463") ;5
(grotte.data/update-row-by-idstring :state "fc6d4791-f2ca-4ebb-aa22-b9ab9a9a3463" :abbr "PA") ;6
(grotte.data/make-row :state :id "79c84c27-b5e0-411e-81ed-066f84b10171") ;7
(grotte.data/update-row-by-idstring :state "79c84c27-b5e0-411e-81ed-066f84b10171" :abbr "RI") ;8
(grotte.data/make-row :state :id "7e19a6d8-bf3d-487c-8968-befd077225f5") ;9
(grotte.data/update-row-by-idstring :state "7e19a6d8-bf3d-487c-8968-befd077225f5" :abbr "SC") ;10
(grotte.data/make-row :state :id "fc9d7561-eb4b-4a4a-a138-b852214a963e") ;11
(grotte.data/update-row-by-idstring :state "fc9d7561-eb4b-4a4a-a138-b852214a963e" :abbr "SD") ;12
(grotte.data/make-row :state :id "4d741ad5-5c1a-4e51-bc0c-e0c054f94279") ;13
(grotte.data/update-row-by-idstring :state "4d741ad5-5c1a-4e51-bc0c-e0c054f94279" :abbr "TN") ;14
(grotte.data/make-row :state :id "050ae7bc-f49e-4db6-aecf-3c055fdf3769") ;15
(grotte.data/update-row-by-idstring :state "050ae7bc-f49e-4db6-aecf-3c055fdf3769" :abbr "TX") ;16
(grotte.data/make-row :state :id "61e86aab-d13e-4451-b8ca-be5da9a0c6f0") ;17
(grotte.data/update-row-by-idstring :state "61e86aab-d13e-4451-b8ca-be5da9a0c6f0" :abbr "UT") ;18
(grotte.data/make-row :state :id "1f747582-9ad8-40dd-8ce1-e47d225bef14") ;19
(grotte.data/update-row-by-idstring :state "1f747582-9ad8-40dd-8ce1-e47d225bef14" :abbr "VT") ;20
(grotte.data/make-row :state :id "db0f23c8-cb65-4cf7-a516-da25fc7ab4fb") ;21
(grotte.data/update-row-by-idstring :state "db0f23c8-cb65-4cf7-a516-da25fc7ab4fb" :abbr "VA") ;22
(grotte.data/make-row :state :id "37156b61-c2fe-40c0-a490-c2cd5b3a4ae9") ;23
(grotte.data/update-row-by-idstring :state "37156b61-c2fe-40c0-a490-c2cd5b3a4ae9" :abbr "WA") ;24
(grotte.data/make-row :state :id "1e661fd7-ab68-4309-9075-71093072505c") ;25
(grotte.data/update-row-by-idstring :state "1e661fd7-ab68-4309-9075-71093072505c" :abbr "WV") ;26
(grotte.data/make-row :state :id "10589778-3dfc-4092-805e-e24eceeac867") ;27
(grotte.data/update-row-by-idstring :state "10589778-3dfc-4092-805e-e24eceeac867" :abbr "WI") ;28
(grotte.data/make-row :state :id "82e4693a-f2f3-465f-bd58-14f47a51e129") ;29
(grotte.data/update-row-by-idstring :state "82e4693a-f2f3-465f-bd58-14f47a51e129" :abbr "WY") ;30
(grotte.data/update-row-by-idstring :state "dbdbfb63-3f9a-4f51-9258-331aa0e8caf4" :name "Oklahoma") ;31
(grotte.data/update-row-by-idstring :state "eb1d35e3-9bd7-4537-aba8-2997dafeca4a" :name "Oregon") ;32
(grotte.data/update-row-by-idstring :state "fc6d4791-f2ca-4ebb-aa22-b9ab9a9a3463" :name "Pennsylvania") ;33
(grotte.data/update-row-by-idstring :state "79c84c27-b5e0-411e-81ed-066f84b10171" :name "Rhode Island") ;34
(grotte.data/update-row-by-idstring :state "7e19a6d8-bf3d-487c-8968-befd077225f5" :name "South Carolina") ;35
(grotte.data/update-row-by-idstring :state "fc9d7561-eb4b-4a4a-a138-b852214a963e" :name "South Dakota") ;36
(grotte.data/update-row-by-idstring :state "4d741ad5-5c1a-4e51-bc0c-e0c054f94279" :name "Tennessee") ;37
(grotte.data/update-row-by-idstring :state "050ae7bc-f49e-4db6-aecf-3c055fdf3769" :name "Texas") ;38
(grotte.data/update-row-by-idstring :state "61e86aab-d13e-4451-b8ca-be5da9a0c6f0" :name "Utah") ;39
(grotte.data/update-row-by-idstring :state "1f747582-9ad8-40dd-8ce1-e47d225bef14" :name "Vermont") ;40
(grotte.data/update-row-by-idstring :state "db0f23c8-cb65-4cf7-a516-da25fc7ab4fb" :name "Virginia") ;41
(grotte.data/update-row-by-idstring :state "37156b61-c2fe-40c0-a490-c2cd5b3a4ae9" :name "Washington") ;42
(grotte.data/update-row-by-idstring :state "1e661fd7-ab68-4309-9075-71093072505c" :name "West Virginia") ;43
(grotte.data/update-row-by-idstring :state "10589778-3dfc-4092-805e-e24eceeac867" :name "Wisconsin") ;44
(grotte.data/update-row-by-idstring :state "82e4693a-f2f3-465f-bd58-14f47a51e129" :name "Wyoming") ;45
(grotte.data/make-row :note :id "31edc28d-31ee-4006-be31-9f2ac43067b9") ;1
(grotte.data/delete-row-by-idstring :note "31edc28d-31ee-4006-be31-9f2ac43067b9") ;2
(grotte.data/make-row :note :id "3dc548d4-71e4-4035-b753-7d1c1f07d5a1") ;3
(grotte.data/delete-row-by-idstring :note "31edc28d-31ee-4006-be31-9f2ac43067b9") ;4
(grotte.data/delete-row-by-idstring :note "3dc548d4-71e4-4035-b753-7d1c1f07d5a1") ;5
(grotte.data/update-row-by-idstring :note "31edc28d-31ee-4006-be31-9f2ac43067b9" :date "02/13/2013") ;6
(grotte.data/drop-column :note :body) ;7
(grotte.data/add-column :note :body :editable-text) ;8
(grotte.data/delete-row-by-idstring :note "3dc548d4-71e4-4035-b753-7d1c1f07d5a1") ;9
(grotte.data/delete-row-by-idstring :note "31edc28d-31ee-4006-be31-9f2ac43067b9") ;10
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :body "Hand in hand more monkeys come.") ;11
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "01/01/2013") ;12
(grotte.data/update-row-by-idstring :note "10e22af8-7db8-437c-89ee-2ef75db6db42" :body "This is a third row. I even typed it wrong.") ;13
(grotte.data/delete-row-by-idstring :note "31edc28d-31ee-4006-be31-9f2ac43067b9") ;14
(grotte.data/make-row :note :id "d59a50f5-891d-46e1-aa74-243f1d311183") ;15
(grotte.data/make-row :note :id "aa3c9a71-5539-431f-a506-f28463875ea0") ;1
(grotte.data/update-row-by-idstring :note "d59a50f5-891d-46e1-aa74-243f1d311183" :date "02/12/2013") ;2
(grotte.data/update-row-by-idstring :note "aa3c9a71-5539-431f-a506-f28463875ea0" :date "02/13/2013") ;3
(grotte.data/delete-row-by-idstring :note "d59a50f5-891d-46e1-aa74-243f1d311183") ;4
(grotte.data/make-row :note :id "41f2b1fc-f266-41ea-89c2-1fb3438d1d5c") ;5
(grotte.data/delete-row-by-idstring :note "41f2b1fc-f266-41ea-89c2-1fb3438d1d5c") ;6
(grotte.data/delete-row-by-idstring :note "aa3c9a71-5539-431f-a506-f28463875ea0") ;7
(grotte.data/make-row :note :id "fb00299a-c6bd-40d9-b155-25f2887b3645") ;8
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :body "I have row deletion (which is really row hiding) working pretty nicely.") ;9
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "02/10/2013") ;10
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :body "I have row deletion (which is really row hiding) working pretty nicely. Who could ask for more?") ;11
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :body "I have row deletion (which is really row hiding) working pretty nicely.") ;12
(grotte.data/make-row :note :id "b3e45c5d-e182-4c24-8d05-c775d8535eee") ;13
(grotte.data/update-row-by-idstring :note "b3e45c5d-e182-4c24-8d05-c775d8535eee" :body "Who could ask for more?") ;14
(grotte.data/update-row-by-idstring :note "b3e45c5d-e182-4c24-8d05-c775d8535eee" :date "02/10/2013") ;15
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :litany "Too many words; I truncated most.") ;16
(grotte.data/create-domain :note) ;17
(grotte.data/add-column :note :body :editable-text) ;18
(grotte.data/make-row :note :id "60e83b1e-ab69-49e1-831e-d483ef816670") ;19
(grotte.data/update-row-by-idstring :note "60e83b1e-ab69-49e1-831e-d483ef816670" :body "This is a sample note") ;20
(grotte.data/make-row :note :id "b928a298-16bc-4b0d-96bd-513d8525bf46") ;21
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :body "oeuioeuihhh") ;22
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :body "oeuioeuihhheeeeee") ;23
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :body "oeuioeuihhheeeeeesnotehu santoehu ") ;24
(grotte.data/update-row-by-idstring :note "b3e45c5d-e182-4c24-8d05-c775d8535eee" :body "\"Who could ask for more?\" asks me.") ;1
(grotte.data/update-row-by-idstring :note "b3e45c5d-e182-4c24-8d05-c775d8535eee" :body "Truncated this datum.") ;2
(grotte.data/drop-column :note :body) ;3
(grotte.data/add-column :note :body :editable-text) ;4
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :body "oeuioeuihhheeeeeesnotehu santoehu hhh") ;1
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "02/20/2013") ;2
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "03/20/2013") ;3
(grotte.data/add-column :note :checked :boolean) ;4
(grotte.data/drop-column :note :checked) ;5
(grotte.data/update-row-by-idstring :state "f4326c2c-b360-4c3b-ada3-5467262c0411" :name "Californ-I-A") ;1
(grotte.data/update-row-by-idstring :state "f4326c2c-b360-4c3b-ada3-5467262c0411" :name "California") ;2
(grotte.data/update-row-by-idstring :note "7b4b05e4-40af-4cb5-98e4-8bf01de9fa75" :date "03/21/2013") ;3
(grotte.data/update-row-by-idstring :state "45f154c4-5e29-478f-87f3-854b297424d0" :name "Alabamahh") ;3
(grotte.data/make-row :state :id "62e39f82-5759-4c09-a62d-14227abc08ed") ;4
(grotte.data/update-row-by-idstring :state "62e39f82-5759-4c09-a62d-14227abc08ed" :abbr "DC") ;5
(grotte.data/update-row-by-idstring :state "62e39f82-5759-4c09-a62d-14227abc08ed" :name "District of Columbia") ;6
(grotte.data/update-row-by-idstring :state "45f154c4-5e29-478f-87f3-854b297424d0" :name "Alabama") ;7
(grotte.data/make-row :state :id "c8e3784f-40d4-49dc-b4db-0acb32b14212") ;8
(grotte.data/update-row-by-idstring :state "c8e3784f-40d4-49dc-b4db-0acb32b14212" :abbr "Your") ;9
(grotte.data/update-row-by-idstring :state "c8e3784f-40d4-49dc-b4db-0acb32b14212" :name "Mother") ;10
(grotte.data/update-row-by-idstring :state "c8e3784f-40d4-49dc-b4db-0acb32b14212" :name "Momma") ;11
(grotte.data/delete-row-by-idstring :state "c8e3784f-40d4-49dc-b4db-0acb32b14212") ;12
(grotte.data/make-row :state :id "69093f32-b77c-4c3c-b3c4-a99a20fc3754") ;13
(grotte.data/update-row-by-idstring :state "69093f32-b77c-4c3c-b3c4-a99a20fc3754" :abbr "monkey") ;14
(grotte.data/delete-row-by-idstring :state "69093f32-b77c-4c3c-b3c4-a99a20fc3754") ;15
(grotte.data/delete-row-by-idstring :state "62e39f82-5759-4c09-a62d-14227abc08ed") ;16
(grotte.data/make-row :detail :id "94ec3b95-a5be-400b-bea6-d1be02847fda") ;17
(grotte.data/update-row-by-idstring :detail "94ec3b95-a5be-400b-bea6-d1be02847fda" :litany "This is another of the same thing\nInteresting.") ;18
(grotte.data/update-row-by-idstring :detail "94ec3b95-a5be-400b-bea6-d1be02847fda" :litany "This \nis another of the same thing\nInteresting.") ;19
(grotte.data/delete-row-by-idstring :detail "94ec3b95-a5be-400b-bea6-d1be02847fda") ;20
(grotte.data/make-row :state :id "456f3fa6-ea9f-40c3-abec-3b11be40fa58") ;21
(grotte.data/update-row-by-idstring :state "456f3fa6-ea9f-40c3-abec-3b11be40fa58" :abbr "DC") ;22
(grotte.data/update-row-by-idstring :state "456f3fa6-ea9f-40c3-abec-3b11be40fa58" :name "District of Columbia") ;23
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "2013-10-18") ;24
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "15/11/2013") ;25
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "05/11/2013") ;26
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "11/07/2013") ;27
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "11/11/2013") ;28
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "11/10/2013") ;29
(grotte.data/update-row-by-idstring :note "b3e45c5d-e182-4c24-8d05-c775d8535eee" :date "02/28/2013") ;30
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :date "11/14/2013") ;31
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :date "") ;32
(grotte.data/update-row-by-idstring :note "b928a298-16bc-4b0d-96bd-513d8525bf46" :body "I have made this less awful than it was. And so glad there are edit widgets already made.") ;33
(grotte.data/make-row :detail :id "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;34
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :litany "Here's another detail that needs linking") ;35
(grotte.data/create-domain :sex) ;36
(grotte.data/make-row :sex :id "456a10bd-71a7-4b74-bcb0-80ee4e555d26") ;37
(grotte.data/update-row-by-idstring :sex "456a10bd-71a7-4b74-bcb0-80ee4e555d26" :code "M") ;38
(grotte.data/make-row :sex :id "90eb0b2d-c708-44aa-9f1d-09bb27a98749") ;39
(grotte.data/update-row-by-idstring :sex "90eb0b2d-c708-44aa-9f1d-09bb27a98749" :code "F") ;40
(grotte.data/make-row :sex :id "f1ee6871-906e-4517-89fa-7a3f4ba5c560") ;41
(grotte.data/delete-row-by-idstring :sex "f1ee6871-906e-4517-89fa-7a3f4ba5c560") ;42
(grotte.data/update-row-by-idstring :sex "456a10bd-71a7-4b74-bcb0-80ee4e555d26" :description "Male") ;43
(grotte.data/update-row-by-idstring :sex "90eb0b2d-c708-44aa-9f1d-09bb27a98749" :description "Female") ;44
(grotte.data/create-domain :region) ;45
(grotte.data/make-row :region :id "dea7844b-adc4-4fcc-b19d-e70da9ff64cc") ;46
(grotte.data/update-row-by-idstring :region "dea7844b-adc4-4fcc-b19d-e70da9ff64cc" :name "New England") ;47
(grotte.data/make-row :region :id "0c752b4c-f4bc-45da-8bd6-30f8ec77ff2e") ;48
(grotte.data/make-row :region :id "6abee1ea-f913-4ef6-abda-4d9e301df9a2") ;49
(grotte.data/make-row :region :id "6f638363-ce83-4c5b-8fc0-7a31350ce79b") ;50
(grotte.data/make-row :region :id "de1c833f-98e6-4a4f-b490-9f768c3b3d71") ;51
(grotte.data/update-row-by-idstring :region "0c752b4c-f4bc-45da-8bd6-30f8ec77ff2e" :name "Mid-Atlantic") ;52
(grotte.data/update-row-by-idstring :region "6abee1ea-f913-4ef6-abda-4d9e301df9a2" :name "South") ;53
(grotte.data/update-row-by-idstring :region "6f638363-ce83-4c5b-8fc0-7a31350ce79b" :name "West Coast") ;54
(grotte.data/update-row-by-idstring :region "de1c833f-98e6-4a4f-b490-9f768c3b3d71" :name "Flyover") ;55
(grotte.data/make-row :region :id "c343d800-db86-465c-bdfa-53022b50f39f") ;56
(grotte.data/update-row-by-idstring :region "c343d800-db86-465c-bdfa-53022b50f39f" :name "Coastal") ;57
(grotte.data/delete-row-by-idstring :region "dea7844b-adc4-4fcc-b19d-e70da9ff64cc") ;58
(grotte.data/delete-row-by-idstring :region "0c752b4c-f4bc-45da-8bd6-30f8ec77ff2e") ;59
(grotte.data/delete-row-by-idstring :region "6abee1ea-f913-4ef6-abda-4d9e301df9a2") ;60
(grotte.data/delete-row-by-idstring :region "6f638363-ce83-4c5b-8fc0-7a31350ce79b") ;61
(grotte.data/delete-row-by-idstring :region "de1c833f-98e6-4a4f-b490-9f768c3b3d71") ;62
(grotte.data/delete-row-by-idstring :region "c343d800-db86-465c-bdfa-53022b50f39f") ;63
(grotte.data/make-row :region :id "29ffa439-a8da-42f5-9ece-92adcf155daf") ;64
(grotte.data/delete-row-by-idstring :region "29ffa439-a8da-42f5-9ece-92adcf155daf") ;65
(grotte.data/make-row :detail :id "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;66
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :litany "monkey monkey monkey") ;67
(grotte.data/delete-row-by-idstring :state "456f3fa6-ea9f-40c3-abec-3b11be40fa58") ;1
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;2
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :note "6f09924b-087b-4643-b628-bb5d09b7bb79") ;3
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :litany "Too many words; I truncated most of them.") ;4
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "") ;5
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;6
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "") ;7
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;8
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "") ;9
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :note "") ;10
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;11
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :litany "monkey monkey monkey monkey") ;12
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;13
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "6f09924b-087b-4643-b628-bb5d09b7bb79") ;14
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;15
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "") ;16
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;17
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "6f09924b-087b-4643-b628-bb5d09b7bb79") ;18
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;19
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;20
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;21
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "6f09924b-087b-4643-b628-bb5d09b7bb79") ;22
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;23
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;24
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;25
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;26
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :note "6f09924b-087b-4643-b628-bb5d09b7bb79") ;27
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;28
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;29
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :note "") ;30
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "4a9c08f3-1f63-49fe-aa20-20ef603e4df0") ;31
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :note "") ;32
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;33
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;34
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "ae3b9b2a-0842-429c-8d1f-378ee65d2f5b") ;35
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;36
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :state "492e3396-198e-409a-9b62-f7dca6a13d46") ;37
(grotte.data/update-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;38
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;39
(grotte.data/update-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79" :state "53f37b31-8116-4a50-8a80-d4fbc81ae828") ;40
(grotte.data/update-row-by-idstring :note "60e83b1e-ab69-49e1-831e-d483ef816670" :date "11/13/2013") ;41
(grotte.data/update-row-by-idstring :note "fb00299a-c6bd-40d9-b155-25f2887b3645" :date "") ;42
(data/set-domain-namer :note :body)
(data/set-domain-namer :state :name)
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "fb00299a-c6bd-40d9-b155-25f2887b3645") ;1
(grotte.data/delete-row-by-idstring :detail "a5d1445a-a058-44c6-a117-06174a9d0a2a") ;2
(grotte.data/delete-row-by-idstring :detail "6f09924b-087b-4643-b628-bb5d09b7bb79") ;3
(grotte.data/make-row :detail :id "7a4b0944-5462-41d7-8a42-c4f9d04d663b") ;4
(grotte.data/update-row-by-idstring :detail "7a4b0944-5462-41d7-8a42-c4f9d04d663b" :litany "A new one") ;5
(grotte.data/update-row-by-idstring :detail "7a4b0944-5462-41d7-8a42-c4f9d04d663b" :note "b3e45c5d-e182-4c24-8d05-c775d8535eee") ;6
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "") ;7
(grotte.data/update-row-by-idstring :detail "4a9c08f3-1f63-49fe-aa20-20ef603e4df0" :note "10e22af8-7db8-437c-89ee-2ef75db6db42") ;8
(grotte.data/update-row-by-idstring :detail "7a4b0944-5462-41d7-8a42-c4f9d04d663b" :note "") ;9
