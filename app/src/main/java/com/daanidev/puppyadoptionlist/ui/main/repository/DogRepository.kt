package com.daanidev.puppyadoptionlist.ui.main.repository

import com.daanidev.puppyadoptionlist.R
import com.daanidev.puppyadoptionlist.ui.main.model.PuppyModel

class DogRepository {



    fun getPuppyList():ArrayList<PuppyModel>{

        val puppyList:ArrayList<PuppyModel> =ArrayList()

        puppyList.add(
            PuppyModel(0,"Puppy One","Affenpincher","6 months","Male",3.1f,"White",
            R.drawable.affenpincher))
        puppyList.add( PuppyModel(1,"Puppy Two","Australian Silky","8 months","Male",3.3f,"Light Brown",
            R.drawable.australian_silky))
        puppyList.add( PuppyModel(2,"Puppy Three","Australian Terrier","3 months","Female",3.3f,"Light Brown",
            R.drawable.australian_terrier))
        puppyList.add( PuppyModel(3,"Puppy Four","Bichon Avanses","4 months","Male",3f,"Dark Brown",
            R.drawable.bichon_avanses))
        puppyList.add( PuppyModel(4,"Puppy Five","Bichon Frise","6 months","Female",3.6f,"White",
            R.drawable.bichon_frise))
        puppyList.add( PuppyModel(5,"Puppy Six","Boarder Terrier","9 months","Male",4f,"Light Brown",
            R.drawable.boarder_terrier))
        puppyList.add( PuppyModel(6,"Puppy Seven","Boston Terrier","5 months","Male",3.5f,"Black and white",
            R.drawable.boston_terrier))
        puppyList.add( PuppyModel(7,"Puppy Eight","Brussels Griffon","2 months","Female",3.8f,"Brown",
            R.drawable.brussels_griffon))
        puppyList.add( PuppyModel(8,"Puppy Nine","Cairn Terrier","5 months","Male",3.4f,"Brown",
            R.drawable.brussels_griffon))
        puppyList.add( PuppyModel(9,"Puppy Ten","Cotton De Tulear","6 months","Male",3.3f,"White",
            R.drawable.coton_de_tulear))
        puppyList.add( PuppyModel(10,"Puppy Eleven","Dachshund","4 months","Female",3.3f,"Light Brown",
            R.drawable.dachshund))


        return puppyList
    }

}