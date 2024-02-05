import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

@OptIn(ExperimentalStdlibApi::class) // moshi adapters are experimental
fun main() {
	println("Exercise 1")
	val person = Person("Hello World")
	val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
	val jsonAdapter: JsonAdapter<Person> = moshi.adapter<Person>()
	val json: String = jsonAdapter.toJson(person)
	println(json)
}
