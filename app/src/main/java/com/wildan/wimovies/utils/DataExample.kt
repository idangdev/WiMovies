package com.wildan.wimovies.utils

import com.wildan.wimovies.data.source.local.entity.MoviesEntity
import com.wildan.wimovies.data.source.local.entity.TvShowEntity

object DataExample {

    fun generateMoviesExample(): List<MoviesEntity> {
        var movies = ArrayList<MoviesEntity>()

        // 1
        movies.add(
            MoviesEntity("1m",
        "Mortal Kombat",
                "Fantasy, Action, Adventure, Science Fiction, Thriller",
            "78%",
        "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
        "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg")
        )

        //2
        movies.add(
            MoviesEntity("2m",
                "Godzilla vs. Kong",
                "Science Fiction, Action, Drama",
            "82%",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
        )
        )

        //3
        movies.add(
            MoviesEntity("3m",
                "Nobody",
                "Action, Thriller, Crime",
            "85%",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
        )
        )

        //4
        movies.add(
            MoviesEntity("4m",
                "The Marksman",
                "Action, Thriller, Crime",
            "75%",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6vcDalR50RWa309vBH1NLmG2rjQ.jpg"
        )
        )

        //5
        movies.add(
            MoviesEntity("5m",
                "Tom & Jerry",
                "Comedy, Family, Animation",
            "73%",
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg"
        )
        )

        //6
        movies.add(
            MoviesEntity("6m",
                "Outside the Wire",
                "Thriller, Action, Science Fiction",
            "65%",
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg"
        )
        )

        //7
        movies.add(
            MoviesEntity("7m",
                "Tom Clancy's Without Remorse",
                "Action, Adventure, Thriller, War",
            "72%",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
        )
        )

        //8
        movies.add(
            MoviesEntity("8m",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "Animation, Action, Fantasy",
            "83%",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg"
        )
        )

        //9
        movies.add(
            MoviesEntity("9m",
                "Space Sweepers",
                "Drama, Fantasy, Science Fiction",
            "72%",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg"
        )
        )

        //10
        movies.add(
            MoviesEntity("10m",
                "Below Zero",
                "Action, Crime, Thriller",
            "64%",
                "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg"
        )
        )


        return movies
    }

    fun generateTvShowExample(): List<TvShowEntity>{
        var tvShow = ArrayList<TvShowEntity>()

        //1
        tvShow.add(
            TvShowEntity("1t",
                "The Good Doctor",
                "Drama",
            "86%",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
        )
        )

        //2
        tvShow.add(
            TvShowEntity("2t",
                "Haunted: Latin America",
                "Reality",
            "75%",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg"
        )
        )

        //3
        tvShow.add(
            TvShowEntity("3t",
                "Luis Miguel: The Series",
                "Drama",
            "81%",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
        )
        )

        //4
        tvShow.add(
            TvShowEntity("4t",
                "Game of Thrones",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
            "84%",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
        )
        )

        //5
        tvShow.add(
            TvShowEntity("5t",
                "The Vampire Diaries",
                "Drama, Sci-Fi & Fantasy",
            "83%",
                "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg"
        )
        )

        //6
        tvShow.add(
            TvShowEntity("6t",
                "Vikings",
                "Action & Adventure, Drama",
            "80%",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg"
        )
        )

        //7
        tvShow.add(
            TvShowEntity("7t",
                "Marvel Studios: Legends",
                "Documentary",
            "77%",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg"
        )
        )

        //8
        tvShow.add(
            TvShowEntity("8t",
                "Smallville",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
            "82%",
                "The origins of the world’s greatest hero–from Krypton refugee Kal-el’s arrival on Earth through his tumultuous teen years to Clark Kent’s final steps toward embracing his destiny as the Man of Steel.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8usd5QN9ccLDkOQQf2SqprH4in5.jpg"
        )
        )

        //9
        tvShow.add(
            TvShowEntity("9t",
                "The Mandalorian",
                "Sci-Fi & Fantasy, Action & Adventure, Western, Drama",
            "85%",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
        )
        )

        //10
        tvShow.add(
            TvShowEntity("10t",
                "Breaking Bad",
                "Drama",
            "87%",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ggFHVNu6YYI5L9pCfOacjizRGt.jpg"
        )
        )

        return tvShow
    }

    fun generateRemoteDummyMovies(): List<MoviesEntity> {

        val movies = ArrayList<MoviesEntity>()

        // 1
        movies.add(
            MoviesEntity("1m",
                "Mortal Kombat",
                "Fantasy, Action, Adventure, Science Fiction, Thriller",
                "78%",
                "Washed-up MMA fighter Cole Young, unaware of his heritage, and hunted by Emperor Shang Tsung's best warrior, Sub-Zero, seeks out and trains with Earth's greatest champions as he prepares to stand against the enemies of Outworld in a high stakes battle for the universe.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xGuOF1T3WmPsAcQEQJfnG7Ud9f8.jpg")
        )

        //2
        movies.add(
            MoviesEntity("2m",
                "Godzilla vs. Kong",
                "Science Fiction, Action, Drama",
                "82%",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg"
            )
        )

        //3
        movies.add(
            MoviesEntity("3m",
                "Nobody",
                "Action, Thriller, Crime",
                "85%",
                "Hutch Mansell, a suburban dad, overlooked husband, nothing neighbor — a \"nobody.\" When two thieves break into his home one night, Hutch's unknown long-simmering rage is ignited and propels him on a brutal path that will uncover dark secrets he fought to leave behind.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/oBgWY00bEFeZ9N25wWVyuQddbAo.jpg"
            )
        )

        //4
        movies.add(
            MoviesEntity("4m",
                "The Marksman",
                "Action, Thriller, Crime",
                "75%",
                "Jim Hanson’s quiet life is suddenly disturbed by two people crossing the US/Mexico border – a woman and her young son – desperate to flee a Mexican cartel. After a shootout leaves the mother dead, Jim becomes the boy’s reluctant defender. He embraces his role as Miguel’s protector and will stop at nothing to get him to safety, as they go on the run from the relentless assassins.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6vcDalR50RWa309vBH1NLmG2rjQ.jpg"
            )
        )

        //5
        movies.add(
            MoviesEntity("5m",
                "Tom & Jerry",
                "Comedy, Family, Animation",
                "73%",
                "Tom the cat and Jerry the mouse get kicked out of their home and relocate to a fancy New York hotel, where a scrappy employee named Kayla will lose her job if she can’t evict Jerry before a high-class wedding at the hotel. Her solution? Hiring Tom to get rid of the pesky mouse.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/yMoMlJo2msoVwmuf6k1C78MrB3H.jpg"
            )
        )

        //6
        movies.add(
            MoviesEntity("6m",
                "Outside the Wire",
                "Thriller, Action, Science Fiction",
                "65%",
                "In the near future, a drone pilot is sent into a deadly militarized zone and must work with an android officer to locate a doomsday device.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6XYLiMxHAaCsoyrVo38LBWMw2p8.jpg"
            )
        )

        //7
        movies.add(
            MoviesEntity("7m",
                "Tom Clancy's Without Remorse",
                "Action, Adventure, Thriller, War",
                "72%",
                "An elite Navy SEAL uncovers an international conspiracy while seeking justice for the murder of his pregnant wife.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rEm96ib0sPiZBADNKBHKBv5bve9.jpg"
            )
        )

        //8
        movies.add(
            MoviesEntity("8m",
                "Mortal Kombat Legends: Scorpion's Revenge",
                "Animation, Action, Fantasy",
                "83%",
                "After the vicious slaughter of his family by stone-cold mercenary Sub-Zero, Hanzo Hasashi is exiled to the torturous Netherrealm. There, in exchange for his servitude to the sinister Quan Chi, he’s given a chance to avenge his family – and is resurrected as Scorpion, a lost soul bent on revenge. Back on Earthrealm, Lord Raiden gathers a team of elite warriors – Shaolin monk Liu Kang, Special Forces officer Sonya Blade and action star Johnny Cage – an unlikely band of heroes with one chance to save humanity. To do this, they must defeat Shang Tsung’s horde of Outworld gladiators and reign over the Mortal Kombat tournament.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4VlXER3FImHeFuUjBShFamhIp9M.jpg"
            )
        )

        //9
        movies.add(
            MoviesEntity("9m",
                "Space Sweepers",
                "Drama, Fantasy, Science Fiction",
                "72%",
                "When the crew of a space junk collector ship called The Victory discovers a humanoid robot named Dorothy that's known to be a weapon of mass destruction, they get involved in a risky business deal which puts their lives at stake.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/p9YDHJKvUoi7v2SCd3vLGPae1Xp.jpg"
            )
        )

        //10
        movies.add(
            MoviesEntity("10m",
                "Below Zero",
                "Action, Crime, Thriller",
                "64%",
                "When a prisoner transfer van is attacked, the cop in charge must fight those inside and outside while dealing with a silent foe: the icy temperatures.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/dWSnsAGTfc8U27bWsy2RfwZs0Bs.jpg"
            )
        )


        return movies

    }

    fun generateRemoteDummyTvShow(): List<TvShowEntity> {
        val tvShow = ArrayList<TvShowEntity>()

        //1
        tvShow.add(
            TvShowEntity("1t",
                "The Good Doctor",
                "Drama",
                "86%",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/6tfT03sGp9k4c0J3dypjrI8TSAI.jpg"
            )
        )

        //2
        tvShow.add(
            TvShowEntity("2t",
                "Haunted: Latin America",
                "Reality",
                "75%",
                "Real people's terrifying tales of the chilling, unexplained and paranormal come to life with dramatic reenactments in this reality series.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/Q1ZYG3kDS8iVIHOYOJ9NQmV0q7.jpg"
            )
        )

        //3
        tvShow.add(
            TvShowEntity("3t",
                "Luis Miguel: The Series",
                "Drama",
                "81%",
                "The series dramatizes the life story of Mexican superstar singer Luis Miguel, who has captivated audiences in Latin America and beyond for decades.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/34FaY8qpjBAVysSfrJ1l7nrAQaD.jpg"
            )
        )

        //4
        tvShow.add(
            TvShowEntity("4t",
                "Game of Thrones",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "84%",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
            )
        )

        //5
        tvShow.add(
            TvShowEntity("5t",
                "The Vampire Diaries",
                "Drama, Sci-Fi & Fantasy",
                "83%",
                "The story of two vampire brothers obsessed with the same girl, who bears a striking resemblance to the beautiful but ruthless vampire they knew and loved in 1864.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/kLEha9zVVv8acGFKTX4gjvSR2Q0.jpg"
            )
        )

        //6
        tvShow.add(
            TvShowEntity("6t",
                "Vikings",
                "Action & Adventure, Drama",
                "80%",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg"
            )
        )

        //7
        tvShow.add(
            TvShowEntity("7t",
                "Marvel Studios: Legends",
                "Documentary",
                "77%",
                "Revisit the epic heroes, villains and moments from across the MCU in preparation for the stories still to come. Each dynamic segment feeds directly into the upcoming series — setting the stage for future events. This series weaves together the many threads that constitute the unparalleled Marvel Cinematic Universe.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/EpDuYIK81YtCUT3gH2JDpyj8Qk.jpg"
            )
        )

        //8
        tvShow.add(
            TvShowEntity("8t",
                "Smallville",
                "Sci-Fi & Fantasy, Action & Adventure, Drama",
                "82%",
                "The origins of the world’s greatest hero–from Krypton refugee Kal-el’s arrival on Earth through his tumultuous teen years to Clark Kent’s final steps toward embracing his destiny as the Man of Steel.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/8usd5QN9ccLDkOQQf2SqprH4in5.jpg"
            )
        )

        //9
        tvShow.add(
            TvShowEntity("9t",
                "The Mandalorian",
                "Sci-Fi & Fantasy, Action & Adventure, Western, Drama",
                "85%",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg"
            )
        )

        //10
        tvShow.add(
            TvShowEntity("10t",
                "Breaking Bad",
                "Drama",
                "87%",
                "When Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/ggFHVNu6YYI5L9pCfOacjizRGt.jpg"
            )
        )

        return tvShow
    }

    fun generateDummyMoviesDetail(moviesId: String): MoviesEntity{
        return generateMoviesExample()[0]
    }

    fun generateDummyTvShowDetail(tvShowId: String): TvShowEntity{
        return generateTvShowExample()[0]
    }

    fun generateDummyMoviesDetailBookmarked(movies: MoviesEntity, bookmarked: Boolean): MoviesEntity {
        return MoviesEntity(
            movies.moviesId,
            movies.moviesTitle,
            movies.moviesGenre,
            movies.moviesRating,
            movies.moviesDescription,
            movies.moviesPoster,
            movies.moviesBookmarked)
    }

    fun generateDummyTvShowDetailBookmarked(tvShow: TvShowEntity, bookmarked: Boolean): TvShowEntity{
        return TvShowEntity(
            tvShow.tvShowId,
            tvShow.tvShowTitle,
            tvShow.tvShowGenre,
            tvShow.tvShowRating,
            tvShow.tvShowDescription,
            tvShow.tvShowPoster,
            tvShow.tvShowBookmarked
        )
    }



}